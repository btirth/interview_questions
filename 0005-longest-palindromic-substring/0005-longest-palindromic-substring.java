class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        int resStart = 0;
        int resLen = 1;

        for(int i=0; i<len; i++) {
            // odd Length
            int left = i-1;
            int right = i+1;

            while(left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                if(right - left + 1 > resLen) {
                    resStart = left;
                    resLen = right - left + 1;
                }

                left--;
                right++;
            }

            


            // even length
            left = i;
            right = i + 1;

            while(left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                if(right - left + 1 > resLen) {
                    resStart = left;
                    resLen = right - left + 1;
                }
                
                left--;
                right++;
            }
        }

        return s.substring(resStart, resStart + resLen);
    }
}