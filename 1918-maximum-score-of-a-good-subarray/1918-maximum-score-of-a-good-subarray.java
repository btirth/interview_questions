class Solution {
    int ans = Integer.MIN_VALUE;
    public int maximumScore(int[] nums, int k) {
// as per given req we need to add nums[k] in the array, so we will make. it our middle poin
       helper(nums, k, k, nums[k]);
       return ans;
    }

    void helper(int[] nums, int l, int r, int min) {
        // to make our ans max we need max number, so we are standing on either boundry
// we will go to other way, but we are not on the boundry we will go the side which has maximum
// value, because to calculate ans we need min of subarray and going to maximum side will
// increase our ans.
        ans = Math.max(ans, min*(r-l+1));
        if(l==0 && r==nums.length-1) {
            return;
        } else if(l==0 && r<nums.length-1) {
            helper(nums, l, r+1, Math.min(min, nums[r+1]));
        } else if(l>0 && r==nums.length-1) {
            helper(nums, l-1, r, Math.min(min, nums[l-1]));
        } else if(nums[l-1] == nums[r+1]) {
            helper(nums, l-1, r+1, Math.min(min, nums[r+1]));
        } else if(nums[l-1] < nums[r+1]) {
            helper(nums, l, r+1, Math.min(min, nums[r+1]));
        } else {
            helper(nums, l-1, r, Math.min(min, nums[l-1]));
        }
    }
}