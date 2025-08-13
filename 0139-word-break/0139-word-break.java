class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        /**
        At each index i, we can check if

        
        for i in range (0, len):
            for j in range (i+1, len):
                if dp[j] && wordDict.contains(s.substring(i, j))
                    dp[i] = true
                    found = true
                    break

        
         */

        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[len] = true;

        for(int i=len-1; i >= 0; i--) {
            for(int j=i + 1; j<=len; j++) {
                if(dp[j] && wordDict.contains(s.substring(i, j))) {
                    dp[i] = true;
                    break;
                }
            }
        } 

        return dp[0];
    }
}