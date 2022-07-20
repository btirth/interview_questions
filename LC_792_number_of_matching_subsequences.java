/*

Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
 
Example 1:
Input: s = "abcde", words = ["a","bb","acd","ace"]
Output: 3
Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".

Example 2:
Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
Output: 2
 
Constraints:
  1 <= s.length <= 5 * 10^4
  1 <= words.length <= 5000
  1 <= words[i].length <= 50
  s and words[i] consist of only lowercase English letters.

*/


class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        char[] sChar = s.toCharArray();
        int count = 0;
        for(String word: map.keySet()) {
            char[] wordChar = word.toCharArray();
            
            int sIdx = 0;
            int wordIdx = 0;
            
            while(sIdx<s.length() && wordIdx<word.length()) {
                if(sChar[sIdx] == wordChar[wordIdx]) {
                    sIdx++;
                    wordIdx++;
                } else {
                    sIdx++;
                }
            }
            
            if(wordIdx == word.length()) {
                count += map.get(word);
            }
        }
        
        return count;
    }
}
