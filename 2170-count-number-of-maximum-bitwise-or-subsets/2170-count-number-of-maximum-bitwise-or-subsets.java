class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int len = nums.length;
        int maxOr = 0;
        int freq = 0;

        for(int i=0; i<Math.pow(2, len); i++) {
            int currOr = calculateOr(nums, i);
            if(currOr == maxOr) {
                freq++;
            } else if(currOr > maxOr) {
                maxOr = currOr;
                freq = 1;
            }
        }

        return freq;
    }

    int calculateOr(int[] nums, int j) {
        int currOr = 0;

        for(int i=0; i<nums.length; i++) {
            if((j & (1 << i)) > 0) {
                currOr |= nums[i];
            }
        }

        return currOr;
    }
}