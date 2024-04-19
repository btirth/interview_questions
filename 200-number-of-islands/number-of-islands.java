class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int island = 2; 

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j, (char)(island+'0'));
                    island++;
                }
            }
        }

        return island-2;
    }

    int[][] directions = {
        {0,1}, {1,0}, {-1,0}, {0,-1}
    };

    void dfs(char[][] grid, int i, int j, char island) {
        if(i>= grid.length || j>=grid[0].length || i<0 || j<0 || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = island;
        for(int[] dir: directions) {
            int x = i + dir[0];
            int y = j + dir[1];

            dfs(grid, x, y, island);
        }
    }
}