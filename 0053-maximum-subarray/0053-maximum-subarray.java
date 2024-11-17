class Solution {
    public int maxSubArray(int[] nums) {
        int largestSum = Integer.MIN_VALUE;
        int currSum = 0;
        int sum = 0;
        for(int num: nums) {
            currSum += num;
            largestSum = Math.max(largestSum, currSum);
            if(currSum < 0) {
                currSum = 0;
            }

            
        }

        return largestSum;
    }
}