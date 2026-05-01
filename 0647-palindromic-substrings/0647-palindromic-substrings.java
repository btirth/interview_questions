class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;

        for(int i=0; i<n; i++) {
            // Odd length
            count += countPalindrom(s, i-1, i+1);

            // Even length
            count += countPalindrom(s, i, i+1);
        }

        return count;
    }

    int countPalindrom(String s, int l, int r) {
        int n = s.length();

        while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        int length = r - l - 1;
        if(length%2 == 0) {
            return length / 2;
        }

        return (length + 1) / 2;
    }
}