class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        int l = 0;
        int r = n-1;

        while(l<r) {
            if(s.charAt(l) != s.charAt(r)) {
                break;
            }

            char prefix = s.charAt(l);
            char suffix = s.charAt(r);
            while(l<=r && prefix == s.charAt(l)) {
                l++;
            }

            while(l<=r && suffix == s.charAt(r)) {
                r--;
            }
        }

        return r-l+1;
    }
}