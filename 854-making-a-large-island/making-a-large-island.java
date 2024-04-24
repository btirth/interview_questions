class Solution {
    int maxS = Integer.MIN_VALUE;
    public int largestIsland(int[][] grid) {
        HashMap<Integer, Integer> islands = new HashMap<Integer, Integer>();
        int islandID = 2;
        
        int n = grid.length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    int size = dfs(grid, islandID, i, j);
                    maxS = Math.max(maxS, size);
                    islands.put(islandID, size);
                    islandID++;
                }
            }
        }
        largestIsland(grid, islands);
        return maxS;
    }
    
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    int dfs(int[][] grid, int islandID, int i, int j) {
        if(i<0 || j<0 || i>=grid.length || j>=grid.length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = islandID;
        int size = 1;
        for(int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            
            if(x>=0 && y>=0 && x<grid.length && y<grid.length && grid[x][y] == 1) {
                size += dfs(grid, islandID, x, y);
            }
        }
        
        return size;
    }
    
    
    void largestIsland(int[][] grid, HashMap<Integer, Integer> islands) {
        int n = grid.length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 0) {
                    int size = 1;
                    Set<Integer> set = new HashSet<Integer>();
                    for(int[] dir : directions) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        
                        if(x>=0 && y>=0 && x<n && y<n && grid[x][y]!=0) {
                            set.add(grid[x][y]);
                        }
                    }
                    
                    for(int k: set) {
                        size += islands.get(k);
                    }
                    maxS = Math.max(maxS, size);
                }
            }
        }
    }
}