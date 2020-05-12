/*
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:
1.The length of both num1 and num2 is < 5100.
2.Both num1 and num2 contains only digits 0-9.
3.Both num1 and num2 does not contain any leading zero.
4.You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/




class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length()-1, j = num2.length()-1;
        int carry = 0;
        StringBuilder sum = new StringBuilder();
        while(i>=0 || j>=0) {
            
            int n = carry;
            if(i >= 0) {
                n += num1.charAt(i) - '0';
                i--;
            }
            if(j >= 0) {
                n += num2.charAt(j) - '0';
                j--;
            }
            
            carry = n/10;
            
            sum.append(n%10);
            
        }
        
        if(carry != 0) {
            sum.append(carry);
        }
        
        return sum.reverse().toString();
    }
}