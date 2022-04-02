/*

Given a string s, return true if the s can be palindrome after deleting at most one character from it.

Example 1:
  Input: s = "aba"
  Output: true

Example 2:
  Input: s = "abca"
  Output: true
  Explanation: You could delete the character 'c'.

Example 3:
  Input: s = "abc"
  Output: false

Constraints:
  1 <= s.length <= 10^5
  s consists of lowercase English letters.

*/


class Solution {
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return validPalindrome(s, start, end-1) || validPalindrome(s, start+1, end);
            }
            
            start++;
            end--;
        }
        
        return true;
    }
    
    boolean validPalindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            
            start++;
            end--;
        }
        
        return true;
    }
}
