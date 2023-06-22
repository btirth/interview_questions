class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];
        
        for(int idx=n-1; idx>=0; idx--) {
            for(int buy=0; buy<=1; buy++) {
                for(int count=1; count<=2; count++) {
                    if(buy == 1) {
                        dp[idx][buy][count] = 
                            Math.max(dp[idx+1][0][count] - prices[idx], dp[idx+1][1][count]);
                    } else {
                        dp[idx][buy][count] = 
                            Math.max(dp[idx+1][1][count-1] + prices[idx], dp[idx+1][0][count]);
                    }
                }
            }
        }

        return dp[0][1][2];
    }
}