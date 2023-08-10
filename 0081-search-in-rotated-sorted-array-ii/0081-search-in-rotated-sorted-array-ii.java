class Solution {
    public boolean search(int[] nums, int t) {
        int l = 0;
        int n = nums.length;
        int r = n-1;
        while(l <= r) {
            int mid = l + (r-l)/2;

            if(nums[mid] == t) {
                return true;
            } else if(nums[mid] >= nums[l]) {
                if(nums[mid] == nums[l]) {
                    l = l + 1;
                } else if(t < nums[mid] && t >= nums[l]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if(nums[mid] == nums[r]) {
                    r = r-1;
                } else if(t > nums[mid] && t <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return false;
    }
}