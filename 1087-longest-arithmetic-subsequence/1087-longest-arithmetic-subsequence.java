class Solution {
    public int longestArithSeqLength(int[] nums) {
        int[][] dp = new int[1001][1001];
        int val = 0;
        for(int i=nums.length-1; i>=0; i--) {
            for(int j=i+1; j<nums.length; j++) {
                dp[i][nums[j]-nums[i]+500] = Math.max(dp[i][nums[j]-nums[i]+500], 
                                                        dp[j][nums[j]-nums[i]+500] + 1);
                
                val = Math.max(dp[i][nums[j]-nums[i]+500], val);
            }
        }

        return val+1;
    }
}