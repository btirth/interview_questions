/*

Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. 
If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

A substring is a contiguous sequence of characters within the string.

Example 1:
  Input: s = "ADOBECODEBANC", t = "ABC"
  Output: "BANC"
  Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

Example 2:
  Input: s = "a", t = "a"
  Output: "a"
  Explanation: The entire string s is the minimum window.
  Example 3:
  Input: s = "a", t = "aa"
  Output: ""
  Explanation: 
    Both 'a's from t must be included in the window.
    Since the largest window of s only has one 'a', return empty string.

Constraints:
  m == s.length
  n == t.length
  1 <= m, n <= 105
  s and t consist of uppercase and lowercase English letters.
 
Follow up: Could you find an algorithm that runs in O(m + n) time?

*/


class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n == 0 || s==null || n < m) {
            return "";
        }
        
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for(char ch : t.toCharArray()) {
            int occur = hm.getOrDefault(ch, 0);
            hm.put(ch, occur+1);
        }
        
        int left = 0;
        int minLeft = 0;
        int minRight = 0;
        int minLen = n+1;
        int count = 0;
        for(int right=0; right<n; right++) {
            if(hm.containsKey(s.charAt(right))) {
                hm.put(s.charAt(right), hm.get(s.charAt(right))-1);
                if(hm.get(s.charAt(right)) >= 0) {
                    count++;
                } 
            }
            
            while(count == m) {
                if(right-left+1 < minLen) {
                    minLeft = left;
                    minRight = right+1;
                    minLen = right-left+1;
                }
                if(hm.containsKey(s.charAt(left))) {
                    hm.put(s.charAt(left), hm.get(s.charAt(left))+1);
                    if(hm.get(s.charAt(left)) > 0) {
                        count--;
                    }
                }
                
                left++;
            }
        }
        
        if(minLen > n) {
            return "";
        }
        return s.substring(minLeft, minRight);
    }
}
