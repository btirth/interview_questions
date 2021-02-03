/*

Given two binary strings a and b, return their sum as a binary string.

Example 1:
    Input: a = "11", b = "1"
    Output: "100"

Example 2:
    Input: a = "1010", b = "1011"
    Output: "10101"
 
Constraints:
    1 <= a.length, b.length <= 104
    a and b consist only of '0' or '1' characters.
    Each string does not contain leading zeros except for the zero itself.


*/


class Solution {
    StringBuilder sb = new StringBuilder();
    int c = 0;  //carry
    int i = 0;
    public String addBinary(String a, String b) {
        String s1 = a.length() >= b.length() ? a : b;
        String s2 = a.length() >= b.length() ? b : a;
        int l1 = s1.length();
        int l2 = s2.length();
        int i = 0;
        for(; i<s2.length(); i++) {
            sb.append(add(s1.charAt(l1-i-1), s2.charAt(l2-i-1)));
        }
        for(; i<s1.length(); i++) {
            sb.append(add(s1.charAt(l1-i-1), '0'));
        }
        if(c!=0) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }
    
    char add(char c1, char c2) {
        int sum = Character.getNumericValue(c1) + Character.getNumericValue(c2) + c;
        
        if(sum == 0) {
            return '0';
        } else if(sum == 1) {
            c=0;
            return '1';
        } else if(sum ==2) {
            c = 1;
            return '0';
        } else if(sum == 3) {
            c = 1;
            return '1';
        }
        
        return '0';
    }
}