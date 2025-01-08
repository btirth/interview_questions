class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for(int i=0; i<words.length; i++) {
            for(int j=i+1; j<words.length; j++) {
                if(isPrefixAndSuffix(words[j], words[i])) {
                    count++;
                }
            }
        }

        return count;
    }

    boolean isPrefixAndSuffix(String s, String t) {
        int firstIdx = s.indexOf(t);
        int lastIdx = s.lastIndexOf(t);

        if(firstIdx != 0) {
            return false;
        } else if(lastIdx != s.length() - t.length()) {
            return false;
        }

        return true;
    }
}