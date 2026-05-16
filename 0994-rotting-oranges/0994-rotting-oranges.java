class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> rottenOranges = new LinkedList<>();
        int freshOranges = 0;

        int m = grid.length;
        int n = grid[0].length;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 2) {
                    rottenOranges.add(new int[]{i,j});
                } else if(grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        
        int[][] directions = {
            {0,1},
            {1,0},
            {-1,0},
            {0,-1}
        };
        int time = 0;

        while(!rottenOranges.isEmpty()) {
            int size = rottenOranges.size();
            time++;
            while(size-- > 0) {
                int[] orange = rottenOranges.remove();

                for(int[] dir: directions) {
                    int x = dir[0] + orange[0];
                    int y = dir[1] + orange[1];

                    if(x>=0 && y>=0 && x<m && y<n && grid[x][y] == 1) {
                        freshOranges--;
                        rottenOranges.add(new int[]{x,y});
                        grid[x][y] = 2;
                    }
                }
            }
            
        }

        if(freshOranges != 0) {
            return -1;
        }

        return Math.max(0,time - 1);
    }
}