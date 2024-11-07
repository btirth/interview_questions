class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int minDominoRotations = Math.min(isPossible(tops[0], tops, bottoms), isPossible(bottoms[0], tops, bottoms));

        return minDominoRotations == Integer.MAX_VALUE ? -1 : minDominoRotations;
    }

    int isPossible(int tile, int[] tops, int[] bottoms) {
        int topCount = 0;
        int bottomCount = 0;
        for(int i=0; i<tops.length; i++) {
            if(tops[i] != tile && bottoms[i] != tile) {
                return Integer.MAX_VALUE;
            }

            if(tops[i] == tile) {
                topCount++;
            }

            if(bottoms[i] == tile) {
                bottomCount++;
            }
        }

        return tops.length - Math.max(topCount, bottomCount);
    }
}