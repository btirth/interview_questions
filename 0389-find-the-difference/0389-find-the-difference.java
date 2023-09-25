class Solution {
    public char findTheDifference(String s, String t) {
        int[] chs = new int[26];

        for(char ch: t.toCharArray()) {
            chs[ch-'a']++;
        }

        for(char ch: s.toCharArray()) {
            chs[ch-'a']--;
        }

        for(int i=0; i<26; i++) {
            if(chs[i] > 0) {
                return (char)(i+'a');
            }
        }

        return 'a';
    }
}