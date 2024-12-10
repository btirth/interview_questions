class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums) {
            sum += num;
        }

        if(sum%2 == 1) {
            return false;
        }

        return partition(nums, sum/2);
    }

    boolean partition(int[] nums, int target) {
        int n = nums.length;
        boolean[] dp = new boolean[target + 1];

        for(int i=0; i<n; i++) {
            boolean[] newDp = new boolean[target + 1];
            if(nums[i] > target) {
                return false;
            }
            newDp[nums[i]] = true;

            for(int j=1; j<=target; j++) {
                if(dp[j]) {
                    newDp[j] = true;
                }

                if(dp[j] && j + nums[i] <= target) {
                    newDp[j + nums[i]] = true;

                    if(j + nums[i] == target) {
                        return true;
                    }
                }
            }

            dp = newDp;


        }

        return dp[target];
    }
}