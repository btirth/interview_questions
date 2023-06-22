class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[2][prices.length];
        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], -1);

        return buySell(prices, 0, true, fee, dp);
    }

    int buySell(int[] prices, int idx, boolean buy, int fee, int[][] dp) {
        if(idx == prices.length) {
            return 0;
        }

        if(dp[buy ? 0 : 1][idx] != -1) {
            return dp[buy ? 0 : 1][idx];
        }

        if(buy) {
            return dp[buy ? 0 : 1][idx] = 
                        Math.max(buySell(prices, idx+1, false, fee, dp) - prices[idx], 
                            buySell(prices, idx+1, true, fee, dp));
        } else {
            return dp[buy ? 0 : 1][idx] = 
                        Math.max(buySell(prices, idx+1, true, fee, dp) + prices[idx] - fee, 
                            buySell(prices, idx+1, false, fee, dp));
        }
    }
}