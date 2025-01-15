class Solution {
    Boolean[][][] dp;
    public boolean checkValidString(String s) {
        int n = s.length();
        dp = new Boolean[n][n][n];
        return helper(s, 0, 0, 0);
    }

    boolean helper(String s, int open, int close, int idx) {
        if(idx == s.length()) {
            return open == close;
        }

        if(open < close) {
            return false;
        }

        if(dp[idx][open][close] != null) {
            return dp[idx][open][close];
        }

        if(s.charAt(idx) == '(') {
            if(helper(s, open + 1, close, idx+1)) {
                return dp[idx][open][close] = true;
            }

            return false;
        } else if(s.charAt(idx) == ')') {
            if(helper(s, open, close + 1, idx+1)) {
                return dp[idx][open][close] = true;
            }
        } else {
            if(helper(s, open + 1, close, idx+1) ||
            helper(s, open, close + 1, idx+1) ||
            helper(s, open, close, idx+1)) {
                return dp[idx][open][close] = true;
            }
        }

        return dp[idx][open][close] = false;
    }
}