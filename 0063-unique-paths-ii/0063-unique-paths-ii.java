class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if(grid[m-1][n-1] == 1) {
            return 0;
        }

        int[][] dp = new int[m][n];
        dp[m-1][n-1] = 1;
        for(int i=m-2; i>=0; i--) {
            if(dp[i+1][n-1] == 0 || grid[i][n-1] == 1) {
                continue;
            }
            dp[i][n-1] = 1;
        }

        for(int i=n-2; i>=0; i--) {
            if(dp[m-1][i+1] == 0 || grid[m-1][i] == 1) {
                continue;
            }
            dp[m-1][i] = 1;
        }

        for(int i=m-2; i>=0; i--) {
            for(int j=n-2; j>=0; j--) {
                if(grid[i][j] == 1) {
                    continue;
                }
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(dp[i][j] + "-");
            }
             System.out.println("");
        }

        return dp[0][0];
    }
}