class Solution {
    public int maxScore(String s) {
        /**
        011101
        [1,1,1,1,2,2]
        [4,4,3,2,1,1]
        
        
         */
        int len = s.length();
        int[] zeros = new int[len];
        int[] ones = new int[len];
        zeros[0] = s.charAt(0) == '0' ? 1 : 0;
        ones[len - 1] = s.charAt(len - 1) == '1' ? 1 : 0;


        for(int i=1; i<len; i++) {
            if(s.charAt(i) == '0') {
                zeros[i] = 1 + zeros[i-1];
            } else {
                zeros[i] = zeros[i-1];
            }
        }

        for(int i=len-2; i>=0; i--) {
            if(s.charAt(i) == '1') {
                ones[i] = 1 + ones[i+1];
            } else {
                ones[i] = ones[i+1];
            }
        }

        int ans = 0;
        for(int i=1; i<len ; i++) {
            ans = Math.max(ans, zeros[i-1] + ones[i]);
        }

        return ans;
    }
}