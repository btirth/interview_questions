class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] possible = new boolean[3];

        for(int[] triplet: triplets) {
            if(triplet[0] <= target[0] && 
                triplet[1] <= target[1] && 
                triplet[2] <= target[2]
            ) {
                possible[0] = possible[0] | triplet[0] == target[0];
                possible[1] = possible[1] | triplet[1] == target[1];
                possible[2] = possible[2] | triplet[2] == target[2];
            }

            if(possible[0] && possible[1] && possible[2]) {
                return true;
            }
        }

        return false;
    }
}