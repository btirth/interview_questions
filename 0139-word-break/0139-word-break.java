class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];

        dp[n] = true;

        for(int i=n-1; i >= 0; i--) {
            for(String word: wordDict) {
                int end = i + word.length();
                if(end <= n && dp[end] && s.substring(i, end).equals(word)) {
                    dp[i] = true;
                }
            }
        }

        return dp[0];
    }
}