class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];

        /**
            ""  r   o   s
        ""  0   1   2   3
        h   1   1   2   3
        o   2   2   1   2
        r   3   2   3   2
        s   4   3   3   3
        e   5          

         */

        for(int i=0; i<=m; i++) {
            dp[i][0] = i;
        }

        for(int i=0; i<=n; i++) {
            dp[0][i] = i;
        }

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));
                }
            }
        }

        return dp[m][n];
    }
}