class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;
    }

    int[][] directions = {
        {0,1},
        {1,0},
        {-1,0},
        {0,-1}
    };

    int dfs(int[][] grid, int i, int j) {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = 2;
        int area = 1;
        for(int[] dir: directions) {
            int x = dir[0] + i;
            int y = dir[1] + j;

            area += dfs(grid, x, y);
        }

        return area;
    }
}