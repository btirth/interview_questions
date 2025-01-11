class Solution {
    Integer[][] dp;
    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length][2];
        return helper(prices, 0, 1);
    }

    int helper(int[] prices, int idx, int buy) {
        if(idx >= prices.length) {
            return 0;
        }

        if(dp[idx][buy] != null) {
            return (int) dp[idx][buy];
        }

        int cooldown = helper(prices, idx + 1, buy);

        if(buy == 1) {
            return dp[idx][buy] = Math.max(cooldown, helper(prices, idx + 1, 0) - prices[idx]);
        } else {
            return dp[idx][buy] = Math.max(cooldown, prices[idx] + helper(prices, idx + 2, 1));
        }
    }
}