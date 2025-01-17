class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<=m; i++) {
            dp[i][n] = 1;
        }

        for(int i=m-1; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                dp[i][j] = dp[i+1][j];

                if(s.charAt(i) == t.charAt(j)) {
                    dp[i][j] += dp[i+1][j+1];
                }
            }
        }

        return dp[0][0];
    }

    // int helper(String s, String t, int idx1, int idx2) {
    //     if(idx2 == t.length()) {
    //         return 1;
    //     } else if(idx1 == s.length()) {
    //         return 0;
    //     }

    //     if(dp[idx1][idx2] != null) {
    //         return dp[idx1][idx2];
    //     }
    //     int val = helper(s, t, idx1+1, idx2);
    //     if(s.charAt(idx1) == t.charAt(idx2)) {
    //         val += helper(s, t, idx1+1, idx2+1);
    //     }

    //     return dp[idx1][idx2] = val;
    // } 
}