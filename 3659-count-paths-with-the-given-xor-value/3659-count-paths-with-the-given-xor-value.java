class Solution {
    int m;
    int n;
    int k;
    Integer[][][] dp;
    int mod = 1000000007;
    public int countPathsWithXorValue(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;
        this.k = k;
        dp = new Integer[m][n][16];
        return dfs(grid, 0, 0, 0);
    }

    int dfs(int[][] grid, int i, int j, int xor) {
        if(i<0 || j<0 || i>=m || j>=n) {
            return 0;
        }

        if(i == m-1 && j == n-1) {
            if((xor^grid[i][j]) == k) {
                return 1;
            }

            return 0;
        }

        if(dp[i][j][xor] != null) {
            return dp[i][j][xor];
        }

        return dp[i][j][xor] = (dfs(grid, i+1, j, xor^grid[i][j]) + dfs(grid, i, j+1, xor^grid[i][j]))%mod;
    }
}