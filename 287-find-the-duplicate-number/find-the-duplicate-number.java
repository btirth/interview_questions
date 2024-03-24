class Solution {
    public int findDuplicate(int[] nums) {
        for(int num: nums) {
            int n = Math.abs(num);
            if(nums[n] < 0) {
                return n;
            }

            nums[n] *= -1;
        }

        return -1;
    }
}