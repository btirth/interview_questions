/*

You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.

Example 1:
  Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
  Output: 6
  Explanation: The answer is not 11, because the island must be connected 4-directionally.

Example 2:
  Input: grid = [[0,0,0,0,0,0,0,0]]
  Output: 0

Constraints:
  m == grid.length
  n == grid[i].length
  1 <= m, n <= 50
  grid[i][j] is either 0 or 1.

*/


class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        
        return maxArea;
    }
    
    int dfs(int[][] grid, int r, int c) {
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c] == 0 ) {
            return 0;
        }
        
        grid[r][c] = 0;
        return 1 + dfs(grid, r+0, c+1) + dfs(grid, r+1, c+0) + dfs(grid, r-1, c+0) + dfs(grid, r+0, c-1);
    }
}
