class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] res = new int[n][n];
        for(int i=1; i<n; i++) {
            Arrays.fill(res[i], Integer.MAX_VALUE);
        }

        for(int i=0; i<n; i++) {
            res[0][i] = matrix[0][i];
        }

        int[][] dir = {
            {1,1},
            {1,-1},
            {1,0}
        };

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                for(int[] d: dir) {
                    int x = d[0] + i;
                    int y = d[1] + j;

                    if(x>=0 && y>=0 && x<n && y<n) {
                        res[x][y] = Math.min(res[x][y], res[i][j] + matrix[x][y]);
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            ans = Math.min(ans, res[n-1][i]);
        }

        return ans;
    }
}