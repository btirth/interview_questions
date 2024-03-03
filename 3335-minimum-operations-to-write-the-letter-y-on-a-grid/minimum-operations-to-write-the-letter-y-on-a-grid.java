class Solution {
    public int minimumOperationsToWriteY(int[][] grid) {
        int n = grid.length;
        int n0 = 0;
        int n1 = 0;
        int n2 = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 0) {
                    n0++;
                }
                
                if(grid[i][j] == 1) {
                    n1++;
                }
                
                if(grid[i][j] == 2) {
                    n2++;
                }
            }
        }
        
        int d0 = 0;
        int d1 = 0;
        int d2 = 0;
        
        for(int i=0; i<n/2; i++) {
            if(grid[i][i] == 0) {
                d0++;
            }

            if(grid[i][i] == 1) {
                d1++;
            }

            if(grid[i][i] == 2) {
                d2++;
            }
            
            if(grid[i][n-i-1] == 0) {
                d0++;
            }

            if(grid[i][n-i-1] == 1) {
                d1++;
            }

            if(grid[i][n-i-1] == 2) {
                d2++;
            }
        }
        
        for(int i=n/2; i<n; i++) {
            if(grid[i][n/2] == 0) {
                d0++;
            }

            if(grid[i][n/2] == 1) {
                d1++;
            }

            if(grid[i][n/2] == 2) {
                d2++;
            }
        }
        

        int ans0 = (d1+d2);
        ans0 += (n0-d0);
        ans0 += Math.min(n1-d1, n2-d2);

        int ans1 = (d0+d2);
        ans1 += (n1-d1);
        ans1 += Math.min(n0-d0, n2-d2);

        int ans2 = (d1+d0);
        ans2 += (n2-d2);
        ans2 += Math.min(n1-d1, n0-d0);

        return Math.min(ans0, Math.min(ans1, ans2));
    }
}