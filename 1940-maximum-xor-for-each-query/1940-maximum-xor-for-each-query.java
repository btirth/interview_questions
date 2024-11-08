class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        // XOR
        // 1 0 1
        // 0 1 1
        // 1 1 0
        // 0 0 0


        // invert all the bit
        // 
        
        // invert all the bit of total xor
        // make the bit > 2^maxBit = 0


        int n = nums.length;
        int currXor = 0;
        int[] maximumXor = new int[n];
        int idx = n-1;
        int mask = (1 << maximumBit) - 1;
        for(int num: nums) {
            currXor ^= num;

            int k = currXor ^ mask;
            maximumXor[idx] = k;
            idx--;
        }

        return maximumXor;
    }
}