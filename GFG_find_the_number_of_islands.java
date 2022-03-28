/*

Given a grid of size n*m (n is number of rows and m is number of columns grid has) consisting of '0's(Water) and '1's(Land). Find the number of islands.
Note: An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.
 
Example 1:
  Input: grid = {{0,1},{1,0},{1,1},{1,0}}
  Output: 1
  Explanation:
    The grid is-
    0 1
    1 0
    1 1
    1 0
    All lands are connected.

Example 2:
  Input: grid = {{0,1,1,1,0,0,0},{0,0,1,1,0,1,0}}
  Output: 2
  Expanation:
    The grid is-
    0 1 1 1 0 0 0
    0 0 1 1 0 1 0 
    There are two islands one is colored in blue 
    and other in orange.

Your Task:
You don't need to read or print anything. Your task is to complete the function numIslands() which takes grid as input parameter and returns the total number of islands.
 
Expected Time Compelxity: O(n*m)
Expected Space Compelxity: O(n*m)
 
Constraints:
1 ≤ n, m ≤ 500

*/


class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int islandId = 2;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == '1') {
                    helper(grid, i, j, islandId);
                    islandId++;
                }
            }
        }
    
        
        return islandId-2;
    }
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1,1}, {-1, -1}, {1,-1}, {-1,1}};
    void helper(char[][] grid, int i, int j, int islandId) {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] != '1') {
            return;
        }
        
        grid[i][j] = (char)('0' + islandId);
        for(int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            
            if(i>=0 || j>=0 || i<grid.length || j<grid[0].length || grid[x][y] == '1') {
                helper(grid, x, y, islandId);
            }
        }
        
        return;
        
    }
}
