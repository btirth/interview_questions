class Solution {
    int[][] directions = {
        {0,1},
        {1,0},
        {-1,0},
        {0,-1}
    };

    public int largestIsland(int[][] grid) {
        int island = 2;
        int m = grid.length;
        int n = grid[0].length;
        HashMap<Integer, Integer> islandSize = new HashMap<>();
        int ans = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    islandSize.put(island, dfs(grid, i, j, island));
                    ans = Math.max(ans, islandSize.get(island));
                    island++;
                }
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 0) {
                    Set<Integer> uniqueIslandNumber = new HashSet<>();
                    int size = 1;

                    for(int[] dir: directions) {
                        int x = i + dir[0];
                        int y = j + dir[1];

                        if(x>=0 && y>=0 && x<m && y<n && grid[x][y] != 0) {
                            uniqueIslandNumber.add(grid[x][y]);
                        }
                    }

                    for(int islandNumber: uniqueIslandNumber) {                        
                        size += islandSize.get(islandNumber);
                    }

                    ans = Math.max(ans, size);
                }
            }
        }

        return ans;
    }

    int dfs(int[][] grid, int i, int j, int island) {
        
        grid[i][j] = island;
        int size = 1;
        for(int[] dir: directions) {
            int x = i + dir[0];
            int y = j + dir[1];

            if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y] == 1) {
                size += dfs(grid, x, y, island);
            }
        }

        return size;
    }
}