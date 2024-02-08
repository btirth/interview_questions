class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int i = 1;

        while(i*i <= n) {
            for(int j=i*i; j<=n; j++) {
                dp[j] = Math.min(dp[j], dp[j-i*i] + 1);
            }

            i++;
        }

        return dp[n];
    }
}