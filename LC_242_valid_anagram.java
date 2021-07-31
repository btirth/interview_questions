/*

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:
  Input: s = "anagram", t = "nagaram"
  Output: true

Example 2:
  Input: s = "rat", t = "car"
  Output: false
 
Constraints:
  1 <= s.length, t.length <= 5 * 10^4
  s and t consist of lowercase English letters.
 
Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

*/


class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] ch = new int[26];
        int n = s.length();
        for(int i=0; i<n; i++) {
            ch[s.charAt(i)-'a']++;
            ch[t.charAt(i)-'a']--;
        }
        
        for(int i=0; i<26; i++) {
            if(ch[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
