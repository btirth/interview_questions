class Solution {
    String res = "";
    public String longestPalindrome(String s) {
        int n = s.length();
        
        for(int i=0; i<n; i++) {
            // Odd length
            checkPalindrom(s, i-1, i+1);

            // Even length
            checkPalindrom(s, i, i+1);
        }

        return res;
    }

    void checkPalindrom(String s, int l, int r) {
        int n = s.length();

        while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        int length = (r - l - 1);
        if(length > res.length()) {
            res = s.substring(l+1, r);
        }
    }
}