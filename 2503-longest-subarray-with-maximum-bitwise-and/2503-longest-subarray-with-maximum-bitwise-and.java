class Solution {
    public int longestSubarray(int[] nums) {
        int maxBitwiseAnd = 0;
        int count = 0;
        int ans = 0;
        int len = nums.length;
        
        for(int i=0; i<len; i++) {
            if(nums[i] > maxBitwiseAnd) {
                maxBitwiseAnd = nums[i];
                count = 1;
                ans = 1;
            } else if(nums[i] == maxBitwiseAnd) {
                count++;
            } else {
                count = 0;
            }

            ans = Math.max(ans, count);
        }

        return ans;
    }
}