class Solution {
    public int minBitFlips(int start, int goal) {
        int count = 0;
        int xor = start ^ goal;
        int val = 1;
        for(int i=1; i<=32; i++) {
            if((xor & val) > 0) {
                count++;
            }

            val = 1<<i;
        }
        return count;
    }
}