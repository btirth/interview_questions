class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) {
            return false;
        }

        int n = word1.length();
        int[] ch1 = new int[26];
        int[] ch2 = new int[26];

        for(int i=0; i<n; i++) {
            ch1[word1.charAt(i) - 'a']++;
            ch2[word2.charAt(i) - 'a']++;
        }

        int[] freq = new int[1000001];
        for(int i=0; i<26; i++) {
            if(ch1[i] == 0 && ch2[i] == 0) {
                continue;
            }
            if(ch1[i] > 0 && ch2[i] > 0) {
                if(ch1[i] != ch2[i]) {
                    freq[ch1[i]]++;
                    freq[ch2[i]]--;
                }
            } else {
                return false;
            }
        }

        for(int i=0; i<1000001; i++) {
            if(freq[i] != 0) {
                return false;
            }
        }

        return true;
    }
}