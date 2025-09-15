class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        boolean[] broken = new boolean[26];

        for(char ch: brokenLetters.toCharArray()) {
            broken[ch - 'a'] = true;
        }

        int cnt = 0;
        String[] words = text.split(" ");
        for(String word: words) {
            for(char ch: word.toCharArray()) {
                if(broken[ch - 'a']) {
                    cnt++;
                    break;
                }
            }
        }

        return words.length - cnt;
    }
}