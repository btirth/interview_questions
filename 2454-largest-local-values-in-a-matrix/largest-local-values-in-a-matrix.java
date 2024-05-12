class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] maxLocal = new int[n-2][n-2];
        
        int[][] directions = {
            {0,1},
            {1,0},
            {0,-1},
            {-1,0},
            {1,1},
            {1,-1},
            {-1,-1},
            {-1,1}
        };
        
        for(int i=0; i<n-2; i++) {
            for(int j=0; j<n-2; j++) {
                int maxVal = grid[i+1][j+1];
                for(int[] dir: directions) {
                    int x = i+1+dir[0];
                    int y = j+1+dir[1];
                    
                    if(x>=0 && y>=0 && x<n && y<n) {
                        maxVal = Math.max(maxVal, grid[x][y]);
                    }
                }        
                
                maxLocal[i][j] = maxVal;
            }
        }
        
        return maxLocal;
    }
}