class Solution {
    public int maxSubArray(int[] nums) {
        /**
        If sum goes < 0 -> forget about sum
        If sum < num -> isn't it better to just take num as new sum?
        
         */
        int maxSum = nums[0];
        int sum = 0;

        for(int num: nums) {
            sum = Math.max(num, sum + num);
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}