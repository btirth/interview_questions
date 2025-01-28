class Solution {
    int[][] directions = {
        {0,1},
        {1,0},
        {-1,0},
        {0,-1}
    };
    int m;
    int n;

    public int findMaxFish(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int ans = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] > 0) {
                    ans = Math.max(ans, dfs(grid, i, j));
                }
            }
        }

        return ans;
    }

    int dfs(int[][] grid, int i, int j) {

        int val = grid[i][j];    
        grid[i][j] = -1;

        for(int[] dir: directions) {
            int x = dir[0] + i;
            int y = dir[1] + j;

            if(x>=0 && y>=0 && x<m && y<n && grid[x][y] > 0) {
                val += dfs(grid, x, y);
            }
        }

        return val;
    }
}