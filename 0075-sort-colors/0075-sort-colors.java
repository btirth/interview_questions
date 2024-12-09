class Solution {
    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int m = 0;
       
        while(l<=r && m <= r) {
            if(nums[m] == 0) {
                int temp = nums[l];
                nums[l] = 0;
                nums[m] = temp;
                m++;
                l++;
            } else if(nums[m] == 1) {
                m++;
            } else if(nums[m] == 2) {
                int temp = nums[r];
                nums[r] = 2;
                nums[m] = temp;
                r--;
            }
        }
    }
}