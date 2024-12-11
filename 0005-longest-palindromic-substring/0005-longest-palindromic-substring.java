class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n+1][n+1];
        String longestPalindrome = "";
        for(int i=n-1; i>=0; i--) {
            for(int j=i; j<n; j++) {
                if(i == j) {
                    dp[i][j] = true;
                } else if(i+1 == j) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    if(s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i+1][j-1];
                    } 
                }

                if(dp[i][j] && j - i + 1 > longestPalindrome.length()) {
                    longestPalindrome = s.substring(i, j+1);
                }
            }
        }

        return longestPalindrome;
    }
}