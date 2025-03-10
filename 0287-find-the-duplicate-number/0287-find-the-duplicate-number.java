class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n; i++) {
            int val = Math.abs(nums[i]);
            if(nums[val] < 0) {
                return val;
            }

            nums[val] *= -1;
        }

        return -1;
    }
}