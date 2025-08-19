class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        Arrays.sort(coins);

        for(int coin: coins) {
            for(int amt = coin; amt <= amount; amt++) {
                if(dp[amt - coin] != Integer.MAX_VALUE)
                    dp[amt] = Math.min(dp[amt], dp[amt - coin] + 1);
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}