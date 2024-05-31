class Solution {
    public int[] singleNumber(int[] nums) {
        int n = nums.length;
        if(n == 2) {
            return nums;
        }

        long xor = 0;
        for(int i=0; i<n; i++) {
            xor ^= nums[i];
        }

        int firstDiffBit = (int)(xor & (-xor)); 
        // this will return first bit which is different in 2 ans.

        // now we'll check and xor number which have this bit set and not set.
        int xorBitSet = 0;
        int xorBirNotSet = 0;

        for(int i=0; i<n; i++) {
            if((nums[i] & firstDiffBit) > 0) {
                xorBitSet ^= nums[i];
            } else {
                xorBirNotSet ^= nums[i];
            }
        }

        return new int[]{xorBitSet, xorBirNotSet};
    }
}