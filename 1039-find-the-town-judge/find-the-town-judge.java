class Solution {
    public int findJudge(int n, int[][] trust) {
        int[][] h = new int[n][2];

        for(int[] t: trust) {
            if(t[0] != t[1]) {
                h[t[0]-1][0]++;
                h[t[1]-1][1]++;
            }
        }

        for(int i=0; i<n; i++) {
            if(h[i][0] == 0 && h[i][1] == n-1) {
                return i+1;
            }
        }

        return -1;
    }
}