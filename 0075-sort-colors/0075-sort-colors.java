class Solution {
    public void sortColors(int[] nums) {
        /**
        [2,0,2,1,1,0]

        left = 0, right = 5

        2 -> [0,0,2,1,1,2] (left or idx)++
        0 -> correct place
        2 -> [0,0,1,1,2,2] 
        1 -> 
        
        idx will be always greater than or equals to left and less than or equal to right
        if(nums[idx] == 0)
            nums[idx] = nums[left]
            nums[left] = 0

         */
        int n = nums.length;
        int left = 0;
        int right = n-1;
        int idx = 0;

        while(idx < n) {
            if(nums[idx] == 0 && idx > left) {
                // replace
                nums[idx] = nums[left];
                nums[left] = 0;
                left++;
            } else if(nums[idx] == 2 && idx < right) {
                nums[idx] = nums[right];
                nums[right] = 2;
                right--;
            } else {
                idx++;
            }

            while(left < n && nums[left] == 0) {
                left++;
            }

            while(right >= 0 && nums[right] == 2) {
                right--;
            }
        }

    }
}