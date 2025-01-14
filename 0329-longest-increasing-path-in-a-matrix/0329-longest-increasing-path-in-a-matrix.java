class Solution {
    int[][] directions = {
        {0,1},
        {1,0},
        {-1,0},
        {0,-1}
    };
    Integer[][] dp;
    int m;
    int n;
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        dp = new Integer[m][n];
        int longest = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                longest = Math.max(longest, helper(matrix, i, j));
            }
        }  

        return longest;  
    }

    int helper(int[][] matrix, int r, int c) {

        if(dp[r][c] != null) {
            return dp[r][c];
        }

        int longest = 0;
        for(int[] dir: directions) {
            int x = r + dir[0];
            int y = c + dir[1];


            if(x>=0 && y>=0 && x<m && y<n && matrix[r][c] < matrix[x][y]) {
                longest = Math.max(longest, helper(matrix, x, y));
            }
        }

        return dp[r][c] = longest + 1;
    }
}