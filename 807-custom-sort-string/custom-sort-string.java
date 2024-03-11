class Solution {
    public String customSortString(String order, String s) {
        int[] freq = new int[26];
        for(char ch: s.toCharArray()) {
            freq[ch-'a']++;
        }

        int idx = 0;
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<order.length(); i++) {
            char ch = order.charAt(i);
            while(freq[ch-'a']>0) {
                sb.append(ch);
                freq[ch-'a']--;
            }
        }

        for(int i=0; i<26; i++) {
            while(freq[i]>0) {
                sb.append((char)(i+'a'));
                freq[i]--;
            }
        }

        return new String(sb);
    }
}