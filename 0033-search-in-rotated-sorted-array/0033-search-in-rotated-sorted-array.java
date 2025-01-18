class Solution {
    public int search(int[] nums, int target) {
        /**
        [4,5,6,7,0,1,2] target = 0

        find mid
        nums[mid] == target
            return


        if right is sorted nums[right] > nums[mid]
            if nums[mid] > target
                right = mid - 1
            else
                left = mid + 1
        if left is sorted nums[left] < nums[mid]
            if nums[mid] < target
                left = mid + 1
            else
                right = mid - 1                    

        nums[mid] > target
            
                right = mid - 1    
            
            else
                left = mid + 1

        [1,2,3,4,5]
        [4,5,6,0,1,2,3] 
        [0,1,2,3,4,5,6]

        nums[mid] < target    
            if left is sorted nums[left] < nums[mid]
                left = mid + 1
            else
                right = mid - 1    
         */

        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = (right + left) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[left] <= nums[mid]) {
                if(target > nums[mid]) {
                    left = mid + 1;
                } else if(target < nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if(target < nums[mid]) {
                    right = mid - 1;
                } else if(target > nums[right]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        } 

        return -1;
    }
}