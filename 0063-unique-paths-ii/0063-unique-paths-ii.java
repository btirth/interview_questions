class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    grid[i][j] = -1;
                }
            }
        }

        for(int i=m-1; i>=0; i--) {
            if(grid[i][n-1] == -1) {
                break;
            }

            grid[i][n-1] = 1;
        }

        for(int i=n-1; i>=0; i--) {
            if(grid[m-1][i] == -1) {
                break;
            }

            grid[m-1][i] = 1;
        }

        for(int i=m-2; i>=0; i--) {
            for(int j=n-2; j>=0; j--) {
                if(grid[i][j] == -1) {
                    continue;
                }

                if(grid[i+1][j] != -1) {
                    grid[i][j] += grid[i+1][j];
                }

                if(grid[i][j+1] != -1) {
                    grid[i][j] += grid[i][j+1];
                }
            }
        }

        return grid[0][0] == -1 ? 0 : grid[0][0];
    }
}