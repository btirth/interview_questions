class Solution {
    int n;
    int MOD = 1000000007;
    Integer[][] dp;
    public int specialPerm(int[] nums) {
        n = nums.length;
        dp = new Integer[(1<<n)][n];
        int count = 0;
        for(int i=0; i<n; i++) {
            count = (count + helper(nums, 1<<i, i))%MOD;
        }
        
       return count;
    }
    
    int helper(int[] nums, int msk, int prevIdx) {
        if(dp[msk][prevIdx] != null) {
            return dp[msk][prevIdx];
        }

        if(msk == (1<<n) - 1) {
            return 1;
        } 

        int count = 0;
        for(int i=0; i<n; i++) {
            if((msk&(1<<i)) == 0 && (nums[i]%nums[prevIdx] == 0 || nums[prevIdx]%nums[i] == 0)) {
                count = (count + helper(nums, msk|(1<<i), i))%MOD;
            }
        }

        return dp[msk][prevIdx] = count;
    }
}