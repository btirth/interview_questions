class Solution {
    boolean[] allowedChars = new boolean[128];
    public int countConsistentStrings(String allowed, String[] words) {
        int consistentStringsCount = 0;

        for(char ch: allowed.toCharArray()) {
            allowedChars[ch-'a'] = true;
        }

        for(String word: words) {
            if(validateConsistentString(word)) {
                consistentStringsCount++;
            }
        }
        return consistentStringsCount;
    }

    boolean validateConsistentString(String word) {
        for(char ch: word.toCharArray()) {
            if(!allowedChars[ch-'a']) {
                return false;
            }
        }

        return true;
    }
}