/*

You are given an m x n integer array grid where grid[i][j] could be:
  1 representing the starting square. There is exactly one starting square.
  2 representing the ending square. There is exactly one ending square.
  0 representing empty squares we can walk over.
  -1 representing obstacles that we cannot walk over.
  
Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.

Example 1:
  Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
  Output: 2
  Explanation: We have the following two paths: 
    1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
    2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)

Example 2:
  Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
  Output: 4
  Explanation: We have the following four paths: 
    1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
    2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
    3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
    4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)

Example 3:
  Input: grid = [[0,1],[2,0]]
  Output: 0
  Explanation: There is no path that walks over every empty square exactly once.
    Note that the starting and ending square can be anywhere in the grid.
 
Constraints:
  m == grid.length
  n == grid[i].length
  1 <= m, n <= 20
  1 <= m * n <= 20
  -1 <= grid[i][j] <= 2
  There is exactly one starting cell and one ending cell.

*/

class Solution {
    public int uniquePathsIII(int[][] grid) {
        int[] startPoint = new int[2];
        int[] endPoint = new int[2];

        int m = grid.length;
        int n = grid[0].length;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    startPoint[0] = i;
                    startPoint[1] = j;
                } else if(grid[i][j] == 2) {
                    endPoint[0] = i;
                    endPoint[1] = j;
                } 
            }
        }

        boolean[][] visited = new boolean[m][n];
        helper(grid, startPoint[0], startPoint[1], endPoint[0], endPoint[1], visited);
        return count;
    }

    int count = 0;

    int[][] directions = {
        {0,1},
        {1,0},
        {0,-1},
        {-1,0}
    };

    boolean isPossible(int[][] grid, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 0 && !visited[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    void helper(int[][] grid, int i, int j, int a, int b, boolean[][] visited) {
        if(i == a && j == b) {
            if(isPossible(grid, visited)) {
                count++;
            }
        }
        visited[i][j] = true;
        for(int[] dir: directions) {
            int x = i + dir[0];
            int y = j + dir[1];

            if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y] != -1 && !visited[x][y]) {
                helper(grid, x, y, a, b, visited);
            }
        }
        visited[i][j] = false;
    }
}
