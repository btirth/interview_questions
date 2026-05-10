class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums) {
            sum += num;
        }

        if(sum % 2 != 0) {
            return false;
        }

        return isPossible(nums, sum / 2);
    }

    boolean isPossible(int[] nums, int target) {
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for(int num: nums) {
            for(int i=target; i>= num; i--) {
                if(dp[i - num]) {
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