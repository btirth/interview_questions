class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = 0;

        for(int num: nums) {
            totalSum += num;
        }

        if(totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;
        return helper(nums, target);
    }

    boolean helper(int[] nums, int target) {
        int n = nums.length;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for(int num: nums) {
            for(int i=target; i >= num; i--) {
                if(!dp[i] && dp[i - num]) {
                    dp[i] = true;

                    if(i == target) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}