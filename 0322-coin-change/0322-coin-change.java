class Solution {
    public int coinChange(int[] coins, int amount) {
        long[] dp = new long[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int coin: coins) {
            for(int amt=coin; amt <= amount; amt++) {
                if(dp[amt - coin] != Integer.MAX_VALUE) {
                    dp[amt] = Math.min(dp[amt], 1 + dp[amt - coin]);
                }
                
            }
        }

        return dp[amount] != Integer.MAX_VALUE ? (int)dp[amount] : -1;
    }
}