class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] topsFreq = new int[7];
        int[] bottomsFreq = new int[7];

        for(int top: tops) {
            topsFreq[top]++;
        }

        for(int bottom: bottoms) {
            bottomsFreq[bottom]++;
        }

        int dominoesLength = tops.length;
        int minDominoRotations = dominoesLength;
        for(int i=1; i<=6; i++) {
            if(topsFreq[i] + bottomsFreq[i] >= dominoesLength && isPossible(i, tops, bottoms)) {
                minDominoRotations = Math.min(minDominoRotations, dominoesLength - Math.max(topsFreq[i], bottomsFreq[i]));
            }
        }

        return minDominoRotations == dominoesLength ? -1 : minDominoRotations;
    }

    boolean isPossible(int tile, int[] tops, int[] bottoms) {
        for(int i=0; i<tops.length; i++) {
            if(tops[i] != tile && bottoms[i] != tile) {
                return false;
            }
        }

        return true;
    }
}