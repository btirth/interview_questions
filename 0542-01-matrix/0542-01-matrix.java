class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        
        int[][] ans = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(mat[i][j] == 0) {
                    q.add(new int[]{i,j});
                }
            }
        }
        
        int[][] directions = {
            {0,1},
            {1,0},
            {-1,0},
            {0,-1}
        };
        int count = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int[] pt = q.poll();
                ans[pt[0]][pt[1]] = count;
                for(int[] dir: directions) {
                    int x = pt[0]+dir[0];
                    int y = pt[1]+dir[1];
                    if(x>=0 && y>=0 && x<m && y<n && mat[x][y] == 1) {
                        q.add(new int[]{x,y});
                        mat[x][y] = 0;
                    }
                }
            }
            
            count++;
        }
        
        return ans;
    }
}