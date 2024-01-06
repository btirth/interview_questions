class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int ans = 0;

        for(int i=0; i<n; i++) {
            int maxSeq = 0;
            for(int j=i-1; j>=0; j--) {
                if(nums[i] > nums[j]) {
                    maxSeq = Math.max(maxSeq, dp[j]);
                }
            }

            dp[i] = maxSeq + 1;
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}