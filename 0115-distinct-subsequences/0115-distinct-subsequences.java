class Solution {
    Integer[][] dp;
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        dp = new Integer[m][n];

        return helper(s, t, 0, 0);
    }

    int helper(String s, String t, int idx1, int idx2) {
        if(idx2 == t.length()) {
            return 1;
        } else if(idx1 == s.length()) {
            return 0;
        }

        if(dp[idx1][idx2] != null) {
            return dp[idx1][idx2];
        }
        int val = helper(s, t, idx1+1, idx2);
        if(s.charAt(idx1) == t.charAt(idx2)) {
            val += helper(s, t, idx1+1, idx2+1);
        }

        return dp[idx1][idx2] = val;
    } 
}