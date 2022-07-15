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
        int area=0;
		// Loop over the Entire Grid
        for(int i=0;i< grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
			    // only call the dfs call when we encounter a 1, then find the number of connected land and compare it with the previous area
                if(grid[i][j]==1){
                    area= Math.max(area, dfs(grid, i, j));
                }
            }
        }
        return area;
    }
    
    public int dfs(int[][] grid, int i, int j){
		// if we gets out of bound or its a 0 i.e. water then return 0
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0) return 0;
		// if not then mark the grid value to 0 to make sure we do not come back to the same piece of land and cause infinite recursion i.e. stack over flow
        grid[i][j]=0;
		// now just go to all 4 direction get the respective counts and add it all together and return it
        return 1+ dfs(grid, i-1, j)+ dfs(grid, i+1, j)+ dfs(grid, i, j-1)+ dfs(grid, i, j+1);
    }
}
