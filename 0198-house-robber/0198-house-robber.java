class Solution {
    public int rob(int[] nums) {
        int length = nums.length;

        if(length == 1) {
            return nums[0];
        }
        
        int[] dp = new int[length];
        dp[length - 1] = nums[length - 1];
        dp[length - 2] = Math.max(nums[length - 1], nums[length - 2]);

        for(int i=length - 3; i>=0; i--) {
            dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
        }

        return dp[0];
    }
}