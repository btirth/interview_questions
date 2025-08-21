class Solution {
    Integer[][] dp;
    public int findTargetSumWays(int[] nums, int target) {
        /**
        for every num I've 2 options:
        + or -

        fun(nums, target):
            return func(nums, target - num) + func(nums, target + num)
        

         */

        int totalNumbers = nums.length;
        int totalSum = 0;

        for(int num: nums) {
            totalSum += num;
        }

        if(target > totalSum || target < (-1*totalSum)) {
            return 0;
        }

        dp = new Integer[totalNumbers][totalSum + totalSum + 4];
        return findTargetSumWays(nums, target, 0, totalSum);
    }

    int findTargetSumWays(int[] nums, int target, int idx, int totalSum) {
        if(idx == nums.length || target > totalSum || target < (-1*totalSum)) {
            if(target == 0) {
                return 1;
            }

            return 0;
        }

        if(dp[idx][target + totalSum] != null) {
            return dp[idx][target + totalSum];
        }

        int ways = 0;
        ways += findTargetSumWays(nums, target + nums[idx], idx + 1, totalSum);
        ways += findTargetSumWays(nums, target - nums[idx], idx + 1, totalSum);

        return dp[idx][target + totalSum] = ways;
    }
}