class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;

        for(int i=n-1; i>=0; i--) {
            if(s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }

            dp[i] += dp[i + 1];

             if(i < s.length() - 1 && 
             (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) < '7'))) {
           
                dp[i] += dp[i + 2];
         
            }
        }

        return dp[0];
    }

    // int helper(String s, int idx) {
    //     if(s.length() == idx) {
    //         return 1;
    //     }

    //     if(s.charAt(idx) == '0') {
    //         return 0;
    //     }

    //     if(dp[idx] != -1) {
    //         return dp[idx];
    //     }

    //     int val = 0;
    //     val += helper(s, idx + 1);

    //     if(idx < s.length() - 1 && (s.charAt(idx) == '1' || (s.charAt(idx) == '2' && s.charAt(idx+1) < '7'))) {
           
    //             val += helper(s, idx + 2);
         
    //     }

    //     return dp[idx] = val;
    // }

}