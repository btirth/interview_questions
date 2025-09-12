class Solution {
    public boolean doesAliceWin(String s) {
        int cnt = 0;

        for(char ch: s.toCharArray()) {
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                cnt++;
            }
        }

        return cnt != 0;
    }
}