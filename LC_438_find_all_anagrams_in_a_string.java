/*

Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:
  Input: s = "cbaebabacd", p = "abc"
  Output: [0,6]
  Explanation:
    The substring with start index = 0 is "cba", which is an anagram of "abc".
    The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:
  Input: s = "abab", p = "ab"
  Output: [0,1,2]
  Explanation:
    The substring with start index = 0 is "ab", which is an anagram of "ab".
    The substring with start index = 1 is "ba", which is an anagram of "ab".
    The substring with start index = 2 is "ab", which is an anagram of "ab".
 
Constraints:
  1 <= s.length, p.length <= 3 * 10^4
  s and p consist of lowercase English letters.

*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        Integer[] freq = new Integer[26];
        for(char ch: p.toCharArray()) {
            if(freq[ch-'a'] == null) {
                freq[ch-'a'] = 0;
            }
            freq[ch-'a']++;
        }

        int i = 0;
        int j = 0;
        while(i < s.length()) {
            char ch = s.charAt(i);
            if(freq[ch-'a'] == null) {
                while(j<i) {
                    freq[s.charAt(j)-'a']++;
                    j++;
                }
                j++;
                i++;
            } else if(freq[ch-'a'] > 0) {
                freq[ch-'a']--;

                if(i-j == p.length()-1) {
                    ans.add(j);
                }
                i++;
            } else {
                while(j<i) {
                    freq[s.charAt(j)-'a']++;
                    if(s.charAt(j) == ch) {
                        break;
                    }
                    j++;
                }
                j++;
            }
        }

        return ans;
    }
}
