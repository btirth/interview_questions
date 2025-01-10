class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int l1 = words1.length;
        int l2 = words2.length;
        int[] freq = new int[26];
        List<String> ans = new ArrayList<>();

        for(String word: words2) {
            int[] currFreq = new int[26];
            for(char ch: word.toCharArray()) {
                currFreq[ch - 'a']++;
            }

            for(int i=0; i<26; i++) {
                freq[i] = Math.max(freq[i], currFreq[i]);
            }
        }

        for(String word: words1) {
            int[] currFreq = new int[26];
            for(char ch: word.toCharArray()) {
                currFreq[ch - 'a']++;
            }

            boolean isUniversal = true;
            for(int i=0; i<26; i++) {
                if(currFreq[i] < freq[i]) {
                    isUniversal = false;
                    break;
                }
            }

            if(isUniversal) {
                ans.add(word);
            }
        }

        return ans;
    }
}