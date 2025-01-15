class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;
        
        for(int i=n-1; i>=0; i--) {
            for(int j=i+1; j<=n; j++) {
                if(wordDict.contains(s.substring(i, j)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }
}