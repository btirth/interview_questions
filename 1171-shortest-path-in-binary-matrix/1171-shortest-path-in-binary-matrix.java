class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] != 0) {
            return -1;
        }

        int n = grid.length;
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        boolean[][] visited = new boolean[n][n];
        int[][] directions = {
            {0,1},
            {1,0},
            {0,-1},
            {-1,0},
            {1,1},
            {-1,-1},
            {1,-1},
            {-1,1}
        };

        q.add(new int[]{0,0});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int[] pt = q.remove();
                if(pt[0] == n-1 && pt[1] == n-1) {
                    return count+1;
                }
                for(int[] dir: directions) {
                    int x = pt[0] + dir[0];
                    int y = pt[1] + dir[1];

                    if(x>=0 && y>=0 && x<n && y<n && !visited[x][y] && grid[x][y] == 0) {
                        visited[x][y] = true;
                        q.add(new int[]{x,y});
                    }
                }
            }
            count++;
        }

        return -1;
    }
}