class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length-1;

        while(l<r) {
            if(nums[l] == -1*nums[r]) {
                return nums[r];
            }

            int left = Math.abs(nums[l]);
            int right = Math.abs(nums[r]);

            if(left > right) {
                l++;
            } else {
                r--;
            }
        }

        return -1;
    }
}