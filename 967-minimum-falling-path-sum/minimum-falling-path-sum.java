class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int[][] dir = {
            {1,1},
            {1,-1},
            {1,0}
        };

        for(int i=n-2; i>=0; i--) {
            for(int j=0; j<n; j++) {
                int val = Integer.MAX_VALUE;
                for(int[] d: dir) {
                    int x = d[0] + i;
                    int y = d[1] + j;

                    if(x>=0 && y>=0 && x<n && y<n) {
                        val = Math.min(val, matrix[x][y]);
                    }
                }

                matrix[i][j] += val;
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            ans = Math.min(ans, matrix[0][i]);
        }

        return ans;
    }
}