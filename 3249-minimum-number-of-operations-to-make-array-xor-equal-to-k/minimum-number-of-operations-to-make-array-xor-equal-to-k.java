class Solution {
    public int minOperations(int[] nums, int k) {
        int count = 0;
        int xor = nums[0];
        for(int i=1; i<nums.length; i++) {
            xor = xor ^ nums[i];
        }

        for(int i=0; i<32; i++) {
            if((xor&(1<<i)) != (k&(1<<i))) {
                count++;
            }
        }

        return count;                
    }
}