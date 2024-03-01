class Solution {
    public String maximumOddBinaryNumber(String s) {
        int count = 0;
        int n = s.length();
        for(int i=0; i<n; i++) {
            if(s.charAt(i) == '1') {
                count++;
            }
        }

        String ans = "";
        for(int i=0; i<count-1; i++) {
            ans += "1";
        }
        for(int i=count-1; i<n-1; i++) {
            ans += "0";
        }
        ans+= '1';
        return ans;
    }
}