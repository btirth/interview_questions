class Solution {
    Integer[][] dp;
    public int findTargetSumWays(int[] nums, int target) {
        dp = new Integer[nums.length][10000];
        return helper(nums, 0, target);
    }

    int helper(int[] nums, int idx, int target) {
        if(idx == nums.length && target == 0) {
            return 1;
        }

        if(idx >= nums.length) {
            return 0;
        }

        if(dp[idx][target+5000] != null) {
            return dp[idx][target+5000];
        }

        return dp[idx][target+5000] = helper(nums, idx+1, target+nums[idx]) + helper(nums, idx+1, target-nums[idx]);
    }
}