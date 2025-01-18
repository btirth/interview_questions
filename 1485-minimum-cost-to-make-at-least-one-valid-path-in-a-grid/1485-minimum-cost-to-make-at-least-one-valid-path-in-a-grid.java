class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] directions = new int[][]{
            {0,1,1},
            {0,-1,2},
            {1,0,3},
            {-1,0,4}
        };

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2], b[2]));
        pq.add(new int[]{0,0,0});

        while(!pq.isEmpty()) {
            int[] top = pq.poll();
            int i = top[0];
            int j = top[1];
            if(i == m-1 && j == n-1) {
                return top[2];
            }

            if(visited[i][j]) {
                continue;
            }

            visited[i][j] = true;
            for(int[] dir: directions) {
                int x = i + dir[0];
                int y = j + dir[1];
                int sign = dir[2];

                if(x>=0 && y>=0 && x<m & y<n && !visited[x][y]) {
                    if(grid[i][j] == sign) {
                        pq.add(new int[]{x,y,top[2]});
                    } else {
                        pq.add(new int[]{x,y,top[2] + 1});
                    }
                }
            } 
        }


        return -1;
    }
}