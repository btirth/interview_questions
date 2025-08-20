class Solution {
    Integer[][] dp;
    public int maxProfit(int[] prices) {
        /**
        prices[i] -> price of the given stock on the ith day.
        as many transactions

        after sell your stock, can't buy on next day.
        
        every day I've 3 options:
        -> do nothing
        -> buy -> next call for sell, day + 1
        -> sell -> next call to buy, day + 2

         */

        int days = prices.length;
        dp = new Integer[days][2]; 
        return trade(prices, 1, 0); 
    }

    int trade(int[] prices, int canBuy, int day) {
        if(day >= prices.length) {
            return 0;
        }

        if(dp[day][canBuy] != null) {
            return dp[day][canBuy];
        }
        
        int profit = trade(prices, canBuy, day + 1);
        
        if(canBuy == 1) {
            profit = Math.max(profit, trade(prices, 0, day + 1) - prices[day]);
        } else {
            profit = Math.max(profit, trade(prices, 1, day + 2) + prices[day]);
        }

        return dp[day][canBuy] = profit;
    }
}