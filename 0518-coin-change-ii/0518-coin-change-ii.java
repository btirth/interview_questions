class Solution {
    Integer[][] dp;
    public int change(int amount, int[] coins) {
        /**
        for coin in coins:
            ways += change(amount - coin, coins, idx);
            ways += change(amount - coin, coins, idx + 1);
         */
        int totalCoins = coins.length; 
        dp = new Integer[amount + 1][totalCoins];
        return waysOfChange(amount, coins, 0);
    }

    int waysOfChange(int amount, int[] coins, int idx) {
        if(amount == 0) {
            return 1;
        } else if(amount < 0 || idx >= coins.length) {
            return 0;
        }

        if(dp[amount][idx] != null) {
            return dp[amount][idx];
        }

        int ways = waysOfChange(amount - coins[idx], coins, idx);
        ways += waysOfChange(amount, coins, idx + 1);

        return dp[amount][idx] = ways;
    }
}