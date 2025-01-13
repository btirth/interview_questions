class Solution {
    public int minimumLength(String s) {
        /**
        1 -> 1
        2 -> 2
        3 -> 1
        4 -> 2
        5 -> 1

        aaa
        
         */

        int n = s.length();
        int[] freq = new int[26];

        for(char ch: s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int length = 0;
        for(int i=0; i<26; i++) {
            if(freq[i] == 0) {
                continue;
            } else if(freq[i] % 2 == 0) {
                length += 2;
            } else {
                length += 1;
            }
        }

        return length;
    }
}