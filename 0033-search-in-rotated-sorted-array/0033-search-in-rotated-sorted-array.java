class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        /**
        [4,5,0,1,2] -> mid = 0, target is 4
        if(left side sorted)
            if nums[left] <= target <nums[mid]
                right = mid - 1;
            else
                left = mid + 1;

        if right side is sorted
            if nums[mid] < target <= nums[right]
                left = mid + 1;
            else
                right = mid - 1;            
        
        
         */
         
        while(left <= right) {
            int mid = (right + left) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[left] <= nums[mid]) {
                if(nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}