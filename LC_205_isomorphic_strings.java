/*
Given two strings s and t, determine if they are isomorphic.
Two strings s and t are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters. 
No two characters may map to the same character, but a character may map to itself.
Example 1:
Input: s = "egg", t = "add"
Output: true
Example 2:
Input: s = "foo", t = "bar"
Output: false
Example 3:
Input: s = "paper", t = "title"
Output: true
 
Constraints:
1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.
*/

class Solution {
    public boolean isIsomorphic(String s, String t) {
       
        int[] s_char = new int[128];
        boolean[] t_char = new boolean[128];
        for(int i=0; i<s.length(); i++) {
            if(s_char[s.charAt(i)] == 0) {
                if(t_char[t.charAt(i)] == true) {
                    return false;
                }
                s_char[s.charAt(i)] = t.charAt(i);
                t_char[t.charAt(i)] = true;
            } else {
                if(s_char[s.charAt(i)] != t.charAt(i)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
