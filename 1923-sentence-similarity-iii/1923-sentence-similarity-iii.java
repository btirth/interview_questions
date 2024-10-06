class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if(sentence1.length() == 0 || sentence2.length() == 0) {
            return true;
        }

        if(sentence1.length() > sentence2.length()) {
            return checkSentencesSimilar(sentence2, sentence1);
        }

        return checkSentencesSimilar(sentence1, sentence2);
    }

    boolean checkSentencesSimilar(String s1, String s2) {
        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");
        int len1 = words1.length;
        int len2 = words2.length;
        int left1 = 0;
        int left2 = 0;
        int right1 = len1-1;
        int right2 = len2-1;

        for(; left1<len1 && left2<len2; left1++, left2++) {
            if(!words1[left1].equals(words2[left2])) {
                break;
            }
        }

        for(; right1>=left1 && right2>=left2; right1--, right2--) {
            if(!words1[right1].equals(words2[right2])) {
                break;
            }
        }

        return left1-1 == right1;
    }
}