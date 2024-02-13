class Solution {
    public String firstPalindrome(String[] words) {
        for(String word: words) {
            if(isValidPalindrome(word)) {
                return word;
            }
        }

        return "";
    }

    boolean isValidPalindrome(String word) {
        int l = 0;
        int r = word.length()-1;

        while(l<r) {
            if(word.charAt(l) != word.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}