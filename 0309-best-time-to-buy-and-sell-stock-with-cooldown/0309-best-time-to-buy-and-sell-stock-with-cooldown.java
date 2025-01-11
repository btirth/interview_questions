class Solution {
    
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 2][2];
        
        for(int idx=n-1; idx>=0; idx--) {
            dp[idx][1] = Math.max(dp[idx + 1][1], dp[idx + 1][0] - prices[idx]);
            dp[idx][0] = Math.max(dp[idx + 1][0], prices[idx] + dp[idx + 2][1]);
        }
        return dp[0][1];
    }

    // int helper(int[] prices, int idx, int buy) {
      

    //     int cooldown = helper(prices, idx + 1, buy);

    //     if(buy == 1) {
    //         return dp[idx][buy] = Math.max(cooldown, helper(prices, idx + 1, 0) - prices[idx]);
    //     } else {
    //         return dp[idx][buy] = Math.max(cooldown, prices[idx] + helper(prices, idx + 2, 1));
    //     }
    // }
}