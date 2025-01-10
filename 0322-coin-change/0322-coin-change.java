class Solution {
    public int coinChange(int[] coins, int amount) {
        /**
        [1,2,5] = target 11

        [1,2,3,4,5,6,....,11]
        [1,1,(3, 1+1), (4, 1+1)]

        So we only need 1D DP    
         */


        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        Arrays.sort(coins);
        for(int coin: coins) {
            if(coin > amount) {
                continue;
            }
            
            dp[coin] = 1;
            for(int i=coin + 1; i<=amount; i++) {
                if(dp[i - coin] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }


        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount]; 
    }
}