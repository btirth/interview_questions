class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[][] dp = new int[high + 1][2];
        int mod = 1000_000_007;
        dp[zero][0] = 1;
        dp[one][1] = 1;

        for(int i=0; i<=high; i++) {
            if(i-zero > 0)
                dp[i][0] += (dp[i-zero][0] + dp[i-zero][1]) % mod;
            
            if(i-one > 0)
                dp[i][1] += (dp[i-one][1] + dp[i-one][0]) % mod;
        }

        int count = 0;
        for(int i=low; i<=high; i++) {
            count = (count + (dp[i][0] + dp[i][1]) % mod) % mod;
        }

        return count;
    }
}