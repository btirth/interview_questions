class Solution {
    public int waysToSplitArray(int[] nums) {
        /**
        
        i + 1 + n - i -1 = n
         */
        int n = nums.length;

        long totalSum = 0;
        for(int num: nums) {
            totalSum += num;
        }

        int ways = 0;
        long prefixSum = 0;
        for(int i=0; i<n-1; i++) {
            prefixSum += nums[i];
            if(prefixSum >= totalSum - prefixSum) {
                ways++;
            }
        }

        return ways;
    }
}