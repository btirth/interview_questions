class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int totalSteps = cost.length;

        int[] dp = new int[totalSteps + 1];
        dp[1] = cost[0];

        for(int i=2; i<=totalSteps; i++) {
            dp[i] = cost[i-1] + Math.min(dp[i-1], dp[i-2]);
        }

        return Math.min(dp[totalSteps], dp[totalSteps - 1]);
    }
}