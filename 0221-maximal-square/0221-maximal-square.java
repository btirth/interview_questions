class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++) {
            dp[i][n-1] = matrix[i][n-1] - '0';
            if(dp[i][n-1] == 1) {
                ans = 1;
            }
        }

        for(int i=0; i<n; i++) {
            dp[m-1][i] = matrix[m-1][i] - '0';
            if(dp[m-1][i] == 1) {
                ans = 1;
            }
        }

        for(int i=m-2; i>=0; i--) {
            for(int j=n-2; j>=0; j--) {
                if(matrix[i][j] == '0') {
                    continue;
                }

                int min = Integer.MAX_VALUE;
                min = Math.min(min, dp[i+1][j+1]);
                min = Math.min(min, dp[i][j+1]);
                min = Math.min(min, dp[i+1][j]);
                
                dp[i][j] = 1 + min;
                
                ans=Math.max(ans, dp[i][j]);
            }
        }


        return ans*ans;
    }
}