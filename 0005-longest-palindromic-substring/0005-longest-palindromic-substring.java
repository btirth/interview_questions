class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for(int i=n-1; i>=0; i--) {
            for(int j=i; j<n; j++) {
                if(i == j) {
                    dp[i][j] = true;
                } else if(i+1 == j) {
                    if(s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                    }
                } else {
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
                        dp[i][j] = true;
                    }
                }
            }
        }

        int[] ans = new int[2];
        int ansLen = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(dp[i][j]) {
                    int len = j - i;

                    if(len > ansLen) {
                        ans = new int[]{i,j};
                        ansLen = len;
                    }
                }
            }
        }

        return s.substring(ans[0], ans[1]+1);
    }
}