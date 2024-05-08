class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        int[][] athletes = new int[n][2];

        for(int i=0; i<n; i++) {
            athletes[i][0] = i;
            athletes[i][1] = score[i];
        }

        Arrays.sort(athletes, (a,b) -> Integer.compare(a[1], b[1]));
        String[] ranks = new String[n];

        for(int i=0; i<n; i++) {
            if(i == n-1) {
                ranks[athletes[i][0]] = "Gold Medal";
            } else if(i == n-2) {
                ranks[athletes[i][0]] = "Silver Medal";
            } else if(i == n-3) {
                ranks[athletes[i][0]] = "Bronze Medal";
            } else {
                ranks[athletes[i][0]] = "" + (n-i);
            }
        }

        return ranks;
    }
}