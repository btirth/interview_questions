class Solution {
    public int maximumDifference(int[] nums) {
        int min = nums[0];
        int ans = -1;
        int n = nums.length;

        for(int i=1; i<n; i++) {
            if(nums[i] == min) {
                continue;
            }
            
            ans = Math.max(ans, nums[i] - min);
            min = Math.min(min, nums[i]);
        }

        return ans;
    }
}