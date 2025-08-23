class Solution {
    int[] dp;

    public int jump(int[] nums) {
        int len = nums.length;
        dp = new int[len];

        Arrays.fill(dp, -1);

        return jump(nums, 0);
    }

    int jump(int[] nums, int idx) {
        if (idx >= nums.length - 1) {
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }
        
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= nums[idx]; i++) {
            min = Math.min(min, jump(nums, idx + i));
        }
        
        if(min == Integer.MAX_VALUE) {
            return dp[idx] = min;
        }

        return dp[idx] = min + 1;
    }
}