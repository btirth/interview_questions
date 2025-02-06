class Solution {
    Boolean[][] dp;
    public boolean checkValidString(String s) {
        int n = s.length();
        dp = new Boolean[n][n];
        
        return helper(s, 0, 0);
    }

    boolean helper(String s, int idx, int open) {
        if(open < 0) {
            return false;
        }

        if(idx == s.length()) {
            return open == 0;
        }

        if(dp[idx][open] != null) {
            return dp[idx][open];
        }

        if(s.charAt(idx) == '(') {
            return dp[idx][open] = helper(s, idx+1, open+1);
        } else if(s.charAt(idx) == ')') {
            return dp[idx][open] = helper(s, idx+1, open-1);
        } else {
            return dp[idx][open] = helper(s, idx+1, open) || 
                helper(s, idx+1, open + 1) || 
                helper(s, idx+1, open - 1);
        }
    }
}