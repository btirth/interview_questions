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
        
        System.out.println(n0+" "+n1+" "+n2+" "+d0+" "+d1+" "+d2);
        return Math.min(helper(n0, n1, n2, d0, d1, d2, 0), 
                        Math.min(helper(n0, n1, n2, d0, d1, d2, 1), helper(n0, n1, n2, d0, d1, d2, 2))
                      );
    }
    
    
    
    int helper(int n0, int n1, int n2, int d0, int d1, int d2, int t) {
        int ans = 0;
        if(t == 0) {
            ans += (d1+d2);
            ans += (n0-d0);
            ans += Math.min(n1-d1, n2-d2);
        }
        
        if(t == 1) {
            ans += (d0+d2);
            ans += (n1-d1);
            ans += Math.min(n0-d0, n2-d2);
        }
        
        if(t == 2) {
            ans += (d1+d0);
            ans += (n2-d2);
            ans += Math.min(n1-d1, n0-d0);
        }
        
        return ans;
    }
}