class Solution {
    public int getMaximumGold(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] != 0) {
                    int gold = helper(grid, i, j, visited);
                    ans = Math.max(ans, gold);
                }
            }
        }
        
        return ans;
    }
    
    int helper(int[][] grid, int i, int j, boolean[][] visited) {
        if(i>=grid.length || j>=grid[0].length || i<0 || j<0) {
            return 0;
        }
        
        if(grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }
        
        visited[i][j] = true;
        int collectedGold = 0;
        collectedGold = Math.max(collectedGold, helper(grid, i-1, j, visited));
        collectedGold = Math.max(collectedGold, helper(grid, i+1, j, visited));
        collectedGold = Math.max(collectedGold, helper(grid, i, j-1, visited));
        collectedGold = Math.max(collectedGold, helper(grid, i, j+1, visited));
        visited[i][j] = false;
        return collectedGold+grid[i][j];
    }
}