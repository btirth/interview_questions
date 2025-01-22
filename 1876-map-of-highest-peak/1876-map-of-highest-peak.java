class Solution {
    public int[][] highestPeak(int[][] isWater) {
        Queue<int[]> q = new LinkedList<>();
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] ans = new int[m][n];

        for(int i=0; i<m; i++) {
            Arrays.fill(ans[i], -1);
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(isWater[i][j] == 1) {
                    q.add(new int[]{i,j});
                    isWater[i][j] = 0;
                }
            }
        }

        int[][] directions = {
            {0,1},
            {1,0},
            {-1,0},
            {0,-1}
        };

        int height = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int[] pt = q.poll();
                if(ans[pt[0]][pt[1]] != -1) {
                    continue;
                }

                ans[pt[0]][pt[1]] = height;
                for(int[] dir: directions) {
                    int x = dir[0] + pt[0];
                    int y = dir[1] + pt[1];

                    if(x>=0 && y>=0 & x<m && y<n && ans[x][y] == -1) {
                        q.add(new int[]{x,y});
                    }
                }
            }

            height++;
        }

        return ans;
    }
}