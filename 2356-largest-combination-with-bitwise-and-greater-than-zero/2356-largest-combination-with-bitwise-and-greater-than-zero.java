class Solution {
    public int largestCombination(int[] candidates) {
        int largestCombination = 0;
        int bit = 1;

        for(int i=0; i<32; i++) {
            int count = 0;
            for(int candidate: candidates) {
                if((candidate & bit) > 0) {
                    count++;
                }
            }

            largestCombination = Math.max(largestCombination, count);
            bit = bit << 1;
        }

        return largestCombination;
    }
}