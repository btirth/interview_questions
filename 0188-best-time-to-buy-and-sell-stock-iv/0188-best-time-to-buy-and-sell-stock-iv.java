class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[2][k+1][prices.length];
        for(int i=0; i<2; i++) {
            for(int j=0; j<=k; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return buySell(prices, 0, true, dp, k);
    }

    int buySell(int[] prices, int idx, boolean buy, int[][][] dp, int count) {
        if(idx == prices.length || count == 0) {
            return 0;
        }

        if(dp[buy ? 0 : 1][count][idx] != -1) {
            return dp[buy ? 0 : 1][count][idx];
        }

        if(buy) {
            return dp[buy ? 0 : 1][count][idx] = 
                Math.max(buySell(prices, idx+1, false, dp, count) - prices[idx], 
                        buySell(prices, idx+1, true, dp, count));
        } else {
            return dp[buy ? 0 : 1][count][idx] = 
                Math.max(buySell(prices, idx+1, true, dp, count-1) + prices[idx], 
                        buySell(prices, idx+1, false, dp, count));
        }
    }
}