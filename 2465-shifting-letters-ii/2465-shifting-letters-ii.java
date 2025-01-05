class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] dp = new int[n + 1];
        for(int[] shift: shifts) {
            int start = shift[0];
            int end = shift[1];
            int dir = shift[2];

            if(dir == 0) {
                dp[end + 1]--;
                dp[start]++;
            } else {
                dp[end + 1]++;
                dp[start]--;
            }
        }

        int diff = 0;
        char[] ch = s.toCharArray();

        for(int i=n; i>0; i--) {
            diff = (diff + dp[i])%26;
            if(diff < 0) {
                diff += 26;
            }
            int val = s.charAt(i-1) - 'a';
            val = (diff + val) % 26;
            ch[i - 1] = (char)(val + 'a');
        }

        return new String(ch);
    }
}