class Solution {
    public int swimInWater(int[][] grid) {
        /**
        the task is to find path from (0, 0) to (n-1, n-1) with minimum value of maximum value in the path.
         */

        int m = grid.length;
        int n = grid[0].length;
        int[][] directions = new int[][] {
            {0,1},
            {1,0},
            {-1,0},
            {0,-1}
        };

        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(grid[a[0]][a[1]], grid[b[0]][b[1]]));

        pq.add(new int[]{0,0});
        int ans = grid[0][0];

        while(!pq.isEmpty()) {
            int[] pt = pq.poll();
            ans = Math.max(ans, grid[pt[0]][pt[1]]);

            if(pt[0] == m-1 && pt[1] == n-1) {
                return ans;
            }

            visited[pt[0]][pt[1]] = true;
            for(int[] dir: directions) {
                int x = pt[0] + dir[0];
                int y = pt[1] + dir[1];

                if(x>=0 && y>=0 && x < m && y < n && !visited[x][y]) {
                    pq.add(new int[]{x,y});
                }
            }
        } 

        return -1;
    }
}