class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];

        for(char ch: s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int vowels = 0;
        int consonant = 0;

        for(int i=0; i<26; i++) {
            if(i == ('a' - 'a') || i == ('e' - 'a') || i == ('i' - 'a') || i == ('o' - 'a') || i == ('u' - 'a')) {
                vowels = Math.max(vowels, freq[i]);
            } else {
                consonant = Math.max(consonant, freq[i]);
            }
        }

        return vowels + consonant;
    }
}