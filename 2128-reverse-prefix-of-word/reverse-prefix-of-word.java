class Solution {
    public String reversePrefix(String word, char ch) {
        int n = word.length();
        char[] chs = word.toCharArray();
        int l = 0;
        int r = 0;
        while(r<n) {
            if(chs[r] == ch) {
                break;
            }
            r++;
        }

        if(r == n) {
            return word;
        }

        while(l<r) {
            char temp = chs[l];
            chs[l] = chs[r];
            chs[r] = temp;
            l++;
            r--;
        }

        return new String(chs);
    }
}