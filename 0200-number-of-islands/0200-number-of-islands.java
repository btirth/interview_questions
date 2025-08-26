class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int islandCount = 0;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    islandCount++;
                }
            }
        }

        return islandCount;
    }
    
    int[][] directions = {
        {0,1},
        {1,0},
        {-1,0},
        {0,-1}
    };

    void dfs(char[][] grid, int i, int j) {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '2';
        for(int[] dir: directions) {
            int x = dir[0] + i;
            int y = dir[1] + j;

            dfs(grid, x, y);
        }
    }
}