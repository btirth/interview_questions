class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int n = nums.length;
        int high = nums.length - 1;

        while(low < high) {
            int mid = (high + low) / 2;
            if((mid == n-1 && nums[mid] > nums[0])) {
                return nums[0];
            }
            else if((mid != n-1 && nums[mid] > nums[mid+1])) {
                return nums[mid+1];
            }
            else if(nums[mid] > nums[low]) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return nums[0];
    }
}