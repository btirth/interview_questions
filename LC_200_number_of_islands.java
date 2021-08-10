/*

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:
  Input: grid = [
    ["1","1","1","1","0"],
    ["1","1","0","1","0"],
    ["1","1","0","0","0"],
    ["0","0","0","0","0"]
  ]
  Output: 1

Example 2:
  Input: grid = [
    ["1","1","0","0","0"],
    ["1","1","0","0","0"],
    ["0","0","1","0","0"],
    ["0","0","0","1","1"]
  ]
  Output: 3

Constraints:
  m == grid.length
  n == grid[i].length
  1 <= m, n <= 300
  grid[i][j] is '0' or '1'.

*/


class Solution {
    public int numIslands(char[][] grid) {
        int islandID = 2;
       
        int n = grid.length;
        int m = grid[0].length;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == '1') {
                    markIsland(grid, i, j, islandID);
                    islandID++;
                }
            }
        }
        return islandID - 2;
    }
    
    int[][] dir = {{-1,0}, {1,0}, {0,1}, {0,-1}};
    public void markIsland(char[][] grid, int i, int j, int islandID) {
        grid[i][j] = (char)(islandID + '0');
        for(int idx=0; idx<4; idx++) {
            int x = i + dir[idx][0];
            int y = j + dir[idx][1];
            
            if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]=='1') {
                markIsland(grid, x, y, islandID);
            }
        }
    }
}
