class Solution {
    public int minBitFlips(int start, int goal) {
        int req = start ^ goal;
        int count = 0;
        for(int i=0; i<32; i++) {
            if((req & 1<<i) > 0) {
                count++;
            }
        }

        return count;
    }
}