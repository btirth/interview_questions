class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[128];
        boolean isSingle = false;
        int count = 0;

        for(char ch: s.toCharArray()) {
            freq[ch-'A']++;
        }

        for(int f: freq) {
            if(f%2 == 1) {
                count += (f-1);
                isSingle = true;
            } else {
                count += f;
            }
        }

        return isSingle ? count+1 : count;
    }
}