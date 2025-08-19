class Solution {
    int[] dp;
    public int numDecodings(String s) {
        /**
        11106

        Can I say -> 1 + findAns(1106)
        1 + 1 + findAns(106)
        11 + findAns(106)
        
        
         */
        int length = s.length();
        dp = new int[length];
        Arrays.fill(dp, -1);
        return decodeString(s, 0);
    }

    int decodeString(String s, int idx) {
        int ways = 0;
        int code = 0;

        if(idx == s.length()) {
            return 1;
        }

        if(s.charAt(idx) == '0') {
            // code cann't start with 0.
            return dp[idx] = 0;
        }
        
        if(dp[idx] != -1) {
            return dp[idx];
        }

        for(int i=idx; i<s.length(); i++) {
            int currDigit = s.charAt(i) - '0';
            code = (code * 10) + currDigit;

            if(code >= 1 && code <= 26) {
                ways += decodeString(s, i + 1);
            } else {
                break;
            }
        }

        return dp[idx] = ways;
    }
}