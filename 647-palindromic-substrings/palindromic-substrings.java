class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        int count = 0;
        for(int i=n-1; i>=0; i--) {
            for(int j=i; j<n; j++) {
                if(i == j) {
                    dp[i][j] = 1;
                } else {
                    if(s.charAt(i) == s.charAt(j)) {
                        if(i+1 == j) {
                            dp[i][j] = 1;
                        } else {
                            dp[i][j] = dp[i+1][j-1];
                        } 
                    } 
                }

                count += dp[i][j];
            }
        }

        return count;
    }
}