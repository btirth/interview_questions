class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        /**
        So the task is to get max sum of subarray with unique elements

        Typical sliding window problem
        
         */

        int maxSum = 0;
        int sum = 0;
        boolean[] present = new boolean[10001];
        int left = 0;
        int len = nums.length;

        for(int right = 0; right < len; right++) {
            if(present[nums[right]]) {
                while(left < right && nums[left] != nums[right]) {
                    sum -= nums[left];
                    present[nums[left]] = false;
                    left++;
                }

                sum -= nums[left];
                left++;
            }

            present[nums[right]] = true;
            sum += nums[right];

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}