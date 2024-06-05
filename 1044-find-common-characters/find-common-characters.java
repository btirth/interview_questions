class Solution {
    public List<String> commonChars(String[] words) {
        int n = words.length;
        int[] freq = new int[26];
        Arrays.fill(freq, Integer.MAX_VALUE);

        for(String word: words) {
            int[] curr = new int[26];
            for(char ch: word.toCharArray()) {
                curr[ch-'a']++;
            }

            for(int i=0; i<26; i++) {
                freq[i] = Math.min(freq[i], curr[i]);
            }
        }

        List<String> ans = new ArrayList<>();
        for(int i=0; i<26; i++) {
            while(freq[i]-- > 0) {
                ans.add(""+(char)(i+'a'));
            }
        }
        return ans;
    }
}