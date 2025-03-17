class Solution {
    public boolean divideArray(int[] nums) {
        int[] freq = new int[501];
        int count = 1;
        int n = nums.length;

        for(int num: nums) {
            freq[num]++;
        }

        for(int i=1; i<=500; i++) {
            if(freq[i] % 2 != 0) {
                return false;
            }
        }

        return true;
    }
}