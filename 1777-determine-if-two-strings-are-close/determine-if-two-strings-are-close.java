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

        HashMap<Integer, Integer> mismatchFreq = new HashMap<>();
        for(int i=0; i<26; i++) {
            if(ch1[i] == 0 && ch2[i] == 0) {
                continue;
            }
            if(ch1[i] > 0 && ch2[i] > 0) {
                if(ch1[i] != ch2[i]) {
                    mismatchFreq.put(ch1[i], mismatchFreq.getOrDefault(ch1[i], 0) + 1);
                    mismatchFreq.put(ch2[i], mismatchFreq.getOrDefault(ch2[i], 0) - 1);
                }
            } else {
                return false;
            }
        }

        for(Map.Entry<Integer, Integer> entry: mismatchFreq.entrySet()) {
            if(entry.getValue() != 0) {
                return false;
            }
        }

        return true;
    }
}