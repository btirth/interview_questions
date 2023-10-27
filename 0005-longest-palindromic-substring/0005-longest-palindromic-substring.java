class Solution {
    public String longestPalindrome(String s) {
        String ans = "" + s.charAt(0);
        int len = 1;
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i=n-1; i>=0; i--) {
            for(int j=i; j<n; j++) {
                if(i == j) {
                    dp[i][j] = 1;
                } else {
                    if(s.charAt(i) == s.charAt(j)) {
                        if(i+1 == j) {
                            dp[i][j] = 2;
                        } else if(dp[i+1][j-1]>0) {
                            dp[i][j] = 2 + dp[i+1][j-1];
                        }

                        if(dp[i][j] > len) {
                            len = dp[i][j];
                            ans = s.substring(i, j+1);
                        }
                    }
                }
            }
        }

        return ans;
    }
}