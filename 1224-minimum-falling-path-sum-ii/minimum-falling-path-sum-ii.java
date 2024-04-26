class Solution {
    int[][] dp;
    int n;
    public int minFallingPathSum(int[][] grid) {
        n = grid.length;
        dp = new int[n][n];
        for(int i=0; i<n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        int minFallPath = Integer.MAX_VALUE;

        for(int i=0; i<n; i++) {
            minFallPath = Math.min(minFallPath, helper(grid, 0, i));
        }

        return minFallPath;
    }

    int helper(int[][] grid, int r, int c) {
        if(c<0 || r<0 || r>=n || c>=n) {
            return Integer.MAX_VALUE;
        }

        if(dp[r][c] != Integer.MAX_VALUE) {
            return dp[r][c];
        }

        int val = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            if(i != c) {
                val = Math.min(val, helper(grid, r+1, i));
            }
        }
        
        return dp[r][c] = grid[r][c] + (val != Integer.MAX_VALUE ? val : 0);
    }
}