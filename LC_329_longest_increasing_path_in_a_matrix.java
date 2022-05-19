/*

Given an m x n integers matrix, return the length of the longest increasing path in matrix.

From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).

Example 1:
  Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
  Output: 4
  Explanation: The longest increasing path is [1, 2, 6, 9].

Example 2:
  Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
  Output: 4
  Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

Example 3:
  Input: matrix = [[1]]
  Output: 1
 
Constraints:
  m == matrix.length
  n == matrix[i].length
  1 <= m, n <= 200
  0 <= matrix[i][j] <= 231 - 1

*/


class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                dp[i][j] = -1;
            }
        }
        
        int ans = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int lip = dfs(matrix, i, j, dp, -1000000000);
                ans = Math.max(ans, lip);
            }
        }
        
        return ans;
    }
    
    int[][] directions = {
        {0,1},
        {1,0},
        {-1,0},
        {0,-1}
    };
    
    int dfs(int[][] matrix, int r, int c, int[][] dp, int prev) {
        if(r<0 || c<0 || r>=matrix.length || c>=matrix[0].length || matrix[r][c] <= prev) {
            return 0;
        }
        
        if(dp[r][c] != -1) {
            return dp[r][c];
        }
        
        int maxLip = 0; 
        for(int[] dir : directions) {
            int newR = r + dir[0];
            int newC = c + dir[1];
            int lip = dfs(matrix, newR, newC, dp, matrix[r][c]);
            maxLip = Math.max(maxLip, lip);
        }
        
        return dp[r][c] = maxLip + 1;
    }
}
