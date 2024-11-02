class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        int len = words.length;

        for(int i=1; i<len; i++) {
            if(words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)) {
                return false;
            }
        }

        return words[0].charAt(0) == words[len-1].charAt(words[len-1].length()-1);
    }
}