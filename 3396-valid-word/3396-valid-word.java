class Solution {
    public boolean isValid(String word) {
        boolean vowel = false;
        boolean consonant = false;
        List<Character> vowels = Arrays.asList(new Character[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'});
        int len = word.length();
        
        if(len < 3) {
            return false;
        }

        for(char ch: word.toCharArray()) {
            if(ch >= '0' && ch <= '9') {
                continue;
            } else if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                if(vowels.contains(ch)) {
                    vowel = true;
                } else {
                    consonant = true;
                }
            } else {
                return false;
            }
        }

        return vowel && consonant;
    }
}