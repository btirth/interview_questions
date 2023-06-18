/*

You are given an m x n integer matrix grid, where you can move from a cell to any adjacent cell in all 4 directions.

Return the number of strictly increasing paths in the grid such that you can start from any cell and end at any cell. 
Since the answer may be very large, return it modulo 109 + 7.

Two paths are considered different if they do not have exactly the same sequence of visited cells.

Example 1:
  Input: grid = [[1,1],[3,4]]
  Output: 8
  Explanation: The strictly increasing paths are:
  - Paths with length 1: [1], [1], [3], [4].
  - Paths with length 2: [1 -> 3], [1 -> 4], [3 -> 4].
  - Paths with length 3: [1 -> 3 -> 4].
  The total number of paths is 4 + 3 + 1 = 8.

Example 2:
  Input: grid = [[1],[2]]
  Output: 3
  Explanation: The strictly increasing paths are:
  - Paths with length 1: [1], [2].
  - Paths with length 2: [1 -> 2].
  The total number of paths is 2 + 1 = 3.
 

Constraints:
  m == grid.length
  n == grid[i].length
  1 <= m, n <= 1000
  1 <= m * n <= 10^5
  1 <= grid[i][j] <= 10^5

*/

class Solution {
    int MOD = 1000000007;
    public int countPaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        int count = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                count += dfs(grid, i, j, dp);
                count %= MOD;
            }
        }

        return count;
    }

    int[][] directions = {
        {0,1},
        {1,0},
        {-1,0},
        {0,-1}
    };

    int dfs(int[][] grid, int i, int j, int[][] dp) {
        if(dp[i][j] != 0) {
            return dp[i][j];
        }

        int val = 1;

        for(int[] dir: directions) {
            int x = i + dir[0];
            int y = j + dir[1];

            if(x>=0 && y>=0 && x < dp.length && y < dp[0].length && grid[i][j] < grid[x][y]) {
                val += dfs(grid, x, y, dp);
                val %= MOD;
            }
        }

        return dp[i][j] = val;
    }
}
