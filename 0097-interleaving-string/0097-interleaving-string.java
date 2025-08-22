class Solution {
    Boolean[][][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        /**
        helper(s1, s2, s3, i1, i2, i3) {
            if(s3[i3] == s1[i1]) {

            }
        }
        
        
         */

        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();

        if(len3 != (len1 + len2)) {
            return false;
        }

        dp = new Boolean[101][101][201];

        return isInterleave(s1, s2, s3, 0, 0, 0);
    }

    boolean isInterleave(String s1, String s2, String s3, int idx1, int idx2, int idx3) {
        if(idx3 == s3.length()) {
            return true;
        }

        if(dp[idx1][idx2][idx3] != null) {
            return dp[idx1][idx2][idx3];
        }

        if(idx1 < s1.length() && s1.charAt(idx1) == s3.charAt(idx3)) {
            if(isInterleave(s1, s2, s3, idx1 + 1, idx2, idx3 + 1)) {
                return dp[idx1][idx2][idx3] = true;
            }
        }

        if(idx2 < s2.length() && s2.charAt(idx2) == s3.charAt(idx3)) {
            if(isInterleave(s1, s2, s3, idx1, idx2 + 1, idx3 + 1)) {
                return dp[idx1][idx2][idx3] = true;
            }
        }

        return dp[idx1][idx2][idx3] = false;
    }
}