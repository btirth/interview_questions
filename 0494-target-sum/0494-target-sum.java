class Solution {
    int[][] dp;
    int sum;
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        sum = 0;
        for(int num: nums) {
            sum += num;
        }

        dp = new int[n][2*sum + 1];

        for(int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return helper(nums, target, 0, 0);
    }

    int helper(int[] nums, int target, int idx, int currSum) {
        if(idx == nums.length) {
            if(currSum == target) {
                return 1;
            }

            return 0;
        }

        if(dp[idx][currSum + sum] != -1) {
            return dp[idx][currSum + sum];
        }

        return dp[idx][currSum + sum] = helper(nums, target, idx + 1, currSum - nums[idx]) + helper(nums, target, idx + 1, currSum + nums[idx]);
    }
}