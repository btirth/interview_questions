class Solution {
    public int jump(int[] nums) {
        /**
        At standing at idx we can check what's min value b/w idx+1 and idx+nums[idx]
        
        
         */

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[n-1] = 0;
        
        for(int i=n-2; i>=0; i--) {
            if(nums[i] == 0) {
                continue;
            }
            
            for(int j=1; j <= nums[i]; j++) {
                if(i + j >= n || dp[i + j] == Integer.MAX_VALUE) {
                    continue;
                }
                
                dp[i] = Math.min(dp[i], 1 + dp[i + j]);
            }
        } 

        return dp[0];
    }
}