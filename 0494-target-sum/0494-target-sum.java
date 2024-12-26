class Solution {
    Integer[][] dp;
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        dp = new Integer[n][20000];
        helper(nums, 0, target);
        return dp[0][1000 + target];
    }

    int helper(int[] nums, int idx, int target) {
        if(idx == nums.length) {
            if(target == 0) {
                return 1;
            }

            return 0;
        }

        if(dp[idx][1000 + target] != null) {
            return dp[idx][1000 + target];
        }

        int negative = helper(nums, idx+1, target-nums[idx]);
        int plus = helper(nums, idx+1, target+nums[idx]);
        return dp[idx][1000 + target] = plus + negative;
    }
}