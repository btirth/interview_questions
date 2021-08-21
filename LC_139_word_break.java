/*

Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:
  Input: s = "leetcode", wordDict = ["leet","code"]
  Output: true
  Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:
  Input: s = "applepenapple", wordDict = ["apple","pen"]
  Output: true
  Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".

Example 3:
  Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
  Output: false
 
Constraints:
  1 <= s.length <= 300
  1 <= wordDict.length <= 1000
  1 <= wordDict[i].length <= 20
  s and wordDict[i] consist of only lowercase English letters.
  All the strings of wordDict are unique.
  
 Note that you are allowed to reuse a dictionary word.

*/



class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[n] = true;
        for(int i=n-1; i>=0; i--) {
            for(String str: wordDict) {
                if(i+str.length() <= n && s.substring(i, i+str.length()).equals(str) ) {
                    dp[i] = dp[i + str.length()];
                }
                
                if(dp[i]) {
                    break;
                }
            }
        }
        
        return dp[0];
    }
}
