class Solution {
    int[][] dp;

    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        dp = new int[n][n+1];

        return helper(cost, time, 0, n);
    }

    int helper(int[] cost, int[] time, int i, int remain) {
        if(remain <= 0) {
            return 0;
        }

        if(i >= cost.length) {
            return (int) 1e9;
        }

        if(dp[i][remain] != 0) {
            return dp[i][remain];
        }

        int paint = cost[i] + helper(cost, time, i + 1, remain - 1 - time[i]);
      
        int skip = helper(cost, time, i + 1, remain);
        return dp[i][remain] = Math.min(paint, skip);
    }
}