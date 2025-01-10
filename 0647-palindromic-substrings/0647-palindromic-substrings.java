class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int count = 0;
        for(int i=len-1; i>=0; i--) {
            for(int j=i; j<len; j++) {
                if(i == j) {
                    dp[i][j] = true;
                } else if(i +1 == j) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
                        dp[i][j] = true;
                    }
                }

                count += dp[i][j] ? 1 : 0;
            }
        }

        return count;
    }
}