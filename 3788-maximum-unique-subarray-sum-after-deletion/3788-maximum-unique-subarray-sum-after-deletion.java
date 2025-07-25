class Solution {
    public int maxSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        int maxVal = -101;

        for(int i=0; i<nums.length; i++) {
            maxVal = Math.max(maxVal, nums[i]);
            if(nums[i] > 0 && (i == 0 || nums[i] != nums[i-1])) {
                sum += nums[i];
            }
        }

        if(sum == 0) {
            return maxVal;
        }

        return sum;
    }
}