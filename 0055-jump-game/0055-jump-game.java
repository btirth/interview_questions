class Solution {
    Boolean[] dp;
    public boolean canJump(int[] nums) {
        int len = nums.length;
        dp = new Boolean[len];
        
        return canJump(nums, 0);
    }

    boolean canJump(int[] nums, int idx) {
        if(idx == nums.length - 1) {
            return true;
        }

        if(dp[idx] != null) {
            return dp[idx];
        }

        for(int i=1; i<=nums[idx]; i++) {
            if(canJump(nums, idx + i)) {
                return dp[idx] = true;
            }
        }

        return dp[idx] = false;
    }
}