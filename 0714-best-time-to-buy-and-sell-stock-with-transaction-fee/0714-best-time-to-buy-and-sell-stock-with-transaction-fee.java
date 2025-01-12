class Solution {
    Integer[][] dp;
    public int maxProfit(int[] prices, int fee) {
        dp = new Integer[prices.length][2];
        return helper(prices, fee, 1, 0);
        
    }

    int helper(int[] prices, int fee, int buy, int idx) {
        if(idx == prices.length) {
            return 0;
        }

        if(dp[idx][buy] != null) {
            return dp[idx][buy];
        }

        int maxProfit = helper(prices, fee, buy, idx+1);
        if(buy == 1) {
            maxProfit = Math.max(maxProfit, - prices[idx] + helper(prices, fee, 0, idx + 1));
            return dp[idx][buy] = maxProfit;
        } else {
            maxProfit = Math.max(maxProfit, prices[idx] - fee + helper(prices, fee, 1, idx + 1));
            return dp[idx][buy] = maxProfit;
        }
    }
}