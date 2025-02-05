class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        char s1ch1 = ',';
        char s1ch2 = ',';
        char s2ch1 = ',';
        char s2ch2 = ',';

        int l1 = s1.length();
        int l2 = s2.length();

        if(l1 != l2) {
            return false;
        }

        int diffCount = 0;
        for(int i=0; i<l1; i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                if(diffCount == 2) {
                    return false;
                }

                if(diffCount == 0) {
                    s1ch1 = s1.charAt(i);
                    s2ch1 = s2.charAt(i);
                } else {
                    s1ch2 = s1.charAt(i);
                    s2ch2 = s2.charAt(i);
                }

                diffCount++;
            }
        }

        if(diffCount == 0) {
            return true;
        }

        if(diffCount == 1) {
            return false;
        }

        return s1ch1 == s2ch2 && s1ch2 == s2ch1;
    }
}