class Solution {
    int[] dp;
    int n;
    public int maxProfit(int[] prices) {
        /**
        [1,2,3,0,2]

        let's say DP
        I say I buy share at 0th day and sell i th day
        so my sub problem is maxProfix from i+2 th day
        
        Recursive calls -> 
        O(n^2)
         */
        n = prices.length;
        dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        return maxProfit(prices, 0); 
    }

    int maxProfit(int[] prices, int startDay) {
        if(startDay >= n) {
            return 0;
        }
        
        if(dp[startDay] != Integer.MIN_VALUE) {
            return dp[startDay];
        }

        int profit = 0;
        for(int i=startDay + 1; i<n; i++) {

            profit = Math.max(profit, prices[i] - prices[startDay] + maxProfit(prices, i + 2));
            profit = Math.max(profit, maxProfit(prices, i));
        }

        return dp[startDay] = profit;
    }
}