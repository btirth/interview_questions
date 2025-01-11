class Solution {
    public int change(int amount, int[] coins) {
        /**
        [1,2,5] -> 5

        Backtracking n^(amount/min(coins))
        0 1 2 3 4 5
        0 1 1 1 1 1
        0 1 2 2 3 3


        4 -> 1111, 112, 22
        5 -> 11111, 1112, 122
    
         */

        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int coin: coins) {
            if(coin > amount) {
                continue;
            }

            for(int i=coin; i<=amount; i++) {
                dp[i] += dp[i-coin];
            }
        } 

        return dp[amount];
    }
}