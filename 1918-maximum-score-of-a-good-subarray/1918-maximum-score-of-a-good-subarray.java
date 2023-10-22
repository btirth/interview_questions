class Solution {
    int ans = Integer.MIN_VALUE;
    public int maximumScore(int[] nums, int k) {
       helper(nums, k, k, nums[k]);
       return ans;
    }

    void helper(int[] nums, int l, int r, int min) {
        
        ans = Math.max(ans, min*(r-l+1));
        if(l==0 && r==nums.length-1) {
            return;
        } else if(l==0 && r<nums.length-1) {
            helper(nums, l, r+1, Math.min(min, nums[r+1]));
        } else if(l>0 && r==nums.length-1) {
            helper(nums, l-1, r, Math.min(min, nums[l-1]));
        } else if(nums[l-1] <= nums[r+1]) {
            helper(nums, l, r+1, Math.min(min, nums[r+1]));
        } else {
            helper(nums, l-1, r, Math.min(min, nums[l-1]));
        }
    }
}