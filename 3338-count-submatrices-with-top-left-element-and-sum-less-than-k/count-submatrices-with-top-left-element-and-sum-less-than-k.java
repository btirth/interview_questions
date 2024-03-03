class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        int count = 0;
        for(int i=0; i<m; i++) {
            int sum = 0;
            for(int j=0; j<n; j++) {
                sum += grid[i][j];
                dp[j] += sum;
                if(dp[j] <= k) {
                    count++;
                }
            }
        }
        
        return count;
    }
}