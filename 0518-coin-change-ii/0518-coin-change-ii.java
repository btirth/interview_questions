class Solution {
    int[][] dp;
    public int change(int amount, int[] coins) {
        /**
        for coin in coins:
            ways += change(amount - coin, coins, idx);
            ways += change(amount - coin, coins, idx + 1);
         */
        int totalCoins = coins.length; 
        dp = new int[totalCoins][amount + 1];

        dp[0][0] = 1;        
        for(int c=0; c<totalCoins; c++) {
            int coin = coins[c];

            for(int i=0; i <= amount; i++) {
                if(i>=coin) {
                    dp[c][i] += dp[c][i - coin];
                }
               
                if(c>0)
                    dp[c][i] += dp[c-1][i];
            }
        }

        return dp[totalCoins-1][amount];
    }

    // int waysOfChange(int amount, int[] coins, int idx) {
    //     if(amount == 0) {
    //         return 1;
    //     } else if(amount < 0 || idx >= coins.length) {
    //         return 0;
    //     }

    //     if(dp[amount][idx] != null) {
    //         return dp[amount][idx];
    //     }

    //     int ways = waysOfChange(amount - coins[idx], coins, idx);
    //     ways += waysOfChange(amount, coins, idx + 1);

    //     return dp[amount][idx] = ways;
    // }
}