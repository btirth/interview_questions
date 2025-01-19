class Solution {
    Integer[][] dp;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNum = new int[n+2];
        dp = new Integer[n+2][n+2];
        newNum[0] = 1;
        newNum[n+1] = 1;

        for(int i=0; i<n; i++) {
            newNum[i+1] = nums[i];
        }

        return helper(newNum, 1, n);
    }

    int helper(int[] nums, int l, int r) {
        if(l > r) {
            return 0;
        }

        if(l == r) {
            return nums[l] * nums[l-1] * nums[r+1];
        }

        if(dp[l][r] != null) {
            return dp[l][r];
        }

        int val = 0;
        for(int i=l; i<=r; i++) {
            val = Math.max(val, (nums[i] * nums[l-1] * nums[r+1]) + helper(nums, l, i-1) + helper(nums, i+1, r));
        }

        return dp[l][r] = val;
    }
}