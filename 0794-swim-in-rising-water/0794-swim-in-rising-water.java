class Solution {
    boolean[][] visited;
    public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int ans = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        int[][] directions = {
            {0,1},
            {1,0},
            {-1,0},
            {0,-1}
        };

        pq.add(new int[]{grid[0][0], 0, 0});

        while(!pq.isEmpty()) {
            int[] pt = pq.poll();
            ans = Math.max(ans, pt[0]);
            int i = pt[1];
            int j = pt[2];
            
            if(visited[i][j]) {
                continue;
            }

            visited[i][j] = true;

            if(i == m-1 && j == n-1) {
                return ans;
            }

            for(int[] dir: directions) {
                int x = i + dir[0];
                int y = j + dir[1];

                if(x>=0 && y>=0 && x<m && y<n && !visited[x][y]) {
                    pq.add(new int[]{grid[x][y], x, y});
                }
            }
        }

        return -1;
    }
}