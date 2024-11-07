class Solution {
    public int largestCombination(int[] candidates) {
        int[] bitSetFreq = new int[32];

        for(int candidate: candidates) {
            int bit = 1;
            for(int i=0; i<32; i++) {
                
                if((candidate & bit) > 0) {
                    bitSetFreq[i]++;
                }

                bit = bit << 1;
            }
        }

        int largestCombination = 0;
        for(int bit: bitSetFreq) {
            largestCombination = Math.max(largestCombination, bit);
        }

        return largestCombination;
    }
}