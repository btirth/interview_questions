class Solution {
    public boolean search(int[] nums, int target) {


        return helper(nums, 0, nums.length-1, target);
    }

    boolean helper(int[] nums, int l, int r, int target) {
        if(l>r) {
            return false;
        }
        int mid = (l+r)/2;

        if(nums[mid] == target) {
            return true;
        }  
        
        if(nums[l] <= nums[mid]) {
            if(target < nums[mid] && target >= nums[l]) {
                if(helper(nums, l, mid-1, target)) {
                    return true;
                }
            } else {
                if(helper(nums, mid+1, r, target)) {
                    return true;
                }
            }
        } 
        
        if(nums[r] >= nums[mid]) {
            if(target > nums[mid] && target <= nums[r]) {
                if(helper(nums, mid+1, r, target)) {
                    return true;
                }
            } else {
                if(helper(nums, l, mid-1, target)) {
                    return true;
                }
            }
        }

        return false;
    }
}