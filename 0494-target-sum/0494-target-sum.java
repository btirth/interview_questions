class Solution {
    int n;
    Integer[][] dp;
    int maxSum;
    public int findTargetSumWays(int[] nums, int target) {
        n = nums.length;
        maxSum = 0;
        for(int num: nums) {
            maxSum += num;
        }

        dp = new Integer[n][(2*maxSum) + 1];
        return helper(nums, target, 0);
    }

    int helper(int[] nums, int target, int idx) {
        if(idx == n || target < -1*maxSum || target > maxSum) {
            if(target == 0) {
                return 1;
            }

            return 0;
        }

        if(dp[idx][target + maxSum] != null) {
            return dp[idx][target + maxSum];
        }

        return dp[idx][target + maxSum] = helper(nums, target - nums[idx], idx+1) + 
                                    helper(nums, target + nums[idx], idx+1);
        
    }
}