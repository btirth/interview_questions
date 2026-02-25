class Solution {
    public int[] sortByBits(int[] arr) {
        List<Integer>[] bitsFreq = new ArrayList[32];
        for(int i=0; i<32; i++) {
            bitsFreq[i] = new ArrayList<>();
        }

        for(int num: arr) {
            int bitCount = 0;
            for(int i=0; i<32; i++) {
                if((num & (1<<i)) != 0) {
                    bitCount++;
                }
            }
            bitsFreq[bitCount].add(num);
        }

        int[] result = new int[arr.length];
        int idx = 0;
        for(int i=0; i<32; i++) {
            Collections.sort(bitsFreq[i]);
            for(int num: bitsFreq[i]) {
                result[idx++] = num;
            }
        }

        return result;
    }
}