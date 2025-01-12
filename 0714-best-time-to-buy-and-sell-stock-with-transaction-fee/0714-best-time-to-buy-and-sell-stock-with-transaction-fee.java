class Solution {
    public int maxProfit(int[] prices, int fee) {
        
        int n = prices.length;
        int[][] dp = new int[prices.length + 1][2];
        dp[n][0] = 0;
        dp[n][1] = 0;
        for(int idx=n-1; idx>=0; idx--) {
            
            dp[idx][1] = Math.max(dp[idx + 1][1], - prices[idx] + dp[idx+1][0]);
            dp[idx][0] = Math.max(dp[idx + 1][0], prices[idx] - fee + dp[idx+1][1]);            
        }
        return dp[0][1];
    }
}