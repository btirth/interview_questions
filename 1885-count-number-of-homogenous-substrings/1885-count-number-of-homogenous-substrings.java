class Solution {
    public int countHomogenous(String s) {
        int mod = 1000000007;
        int count = 1;
        int len = 1;

        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i) == s.charAt(i-1)) {
                len++;
            } else {
                len = 1;
            }
            count = (count + len)%mod;
        }

        return count;
    }
}