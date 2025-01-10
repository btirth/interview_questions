class Solution {
    public int maxProfit(int[] prices) {
        /**
        [1,2,3,0,2]

        let's say DP
        I say I buy share at 0th day and sell i th day
        so my sub problem is maxProfix from i+2 th day
        
        Recursive calls -> 
        O(n^2)


        Now can we convert it into iterative approach ? 
         */
        int n = prices.length;
        int[] dp = new int[n];
        int maxProfit = 0;
        for(int i=n-1; i>=0; i--) {
            for(int j=i+1; j<n; j++) {
                dp[i] = Math.max(dp[i], dp[j]);
                if(j+2 < n) {
                    dp[i] = Math.max(dp[i], prices[j] - prices[i] + dp[j + 2]);
                } else {
                    dp[i] = Math.max(dp[i], prices[j] - prices[i]);
                }
            }

            maxProfit = Math.max(maxProfit, dp[i]);
        }

        return maxProfit; 
    }


    // Apporach 2: Recursive 
    // int maxProfit(int[] prices, int startDay) {
    //     if(startDay >= n) {
    //         return 0;
    //     }

    //     if(dp[startDay] != Integer.MIN_VALUE) {
    //         return dp[startDay];
    //     }

    //     int profit = 0;
    //     for(int i=startDay + 1; i<n; i++) {

    //         profit = Math.max(profit, prices[i] - prices[startDay] + maxProfit(prices, i + 2));
    //         profit = Math.max(profit, maxProfit(prices, i));
    //     }

    //     return dp[startDay] = profit;
    // }
}