class Solution {
    Boolean[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();

        if(len1 + len2 != len3) {
            return false;
        }

        dp = new Boolean[101][101];

        return helper(s1, s2, s3, 0, 0);
    }


    boolean helper(String s1, String s2, String s3, int idx1, int idx2) {
        if(idx1 + idx2 == s3.length()) {
            return true;
        }

        if(dp[idx1][idx2] != null) {
            return dp[idx1][idx2];
        }

        if(idx1 < s1.length() && s1.charAt(idx1) == s3.charAt(idx1 + idx2) && helper(s1, s2, s3, idx1+1, idx2)) {
            return dp[idx1][idx2] = true;
        }

        if(idx2 < s2.length() && s2.charAt(idx2) == s3.charAt(idx1 + idx2) && helper(s1, s2, s3, idx1, idx2+1)) {
            return dp[idx1][idx2] = true;
        }

        return dp[idx1][idx2] = false;
    }
}