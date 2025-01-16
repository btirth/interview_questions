class Solution {
    int[] dp;
    public int numDecodings(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return helper(s, 0);
    }

    int helper(String s, int idx) {
        if(s.length() == idx) {
            return 1;
        }

        if(s.charAt(idx) == '0') {
            return 0;
        }

        if(dp[idx] != -1) {
            return dp[idx];
        }

        int val = 0;
        val += helper(s, idx + 1);

        if(idx < s.length() - 1 && (s.charAt(idx) == '1' || (s.charAt(idx) == '2' && s.charAt(idx+1) < '7'))) {
           
                val += helper(s, idx + 2);
         
        }

        return dp[idx] = val;
    }

}