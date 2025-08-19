class Solution {
    public int countSubstrings(String s) {
        int length = s.length();
        int count = length;

        for(int i=0; i<length; i++) {
            // Odd length
            int j = 1;

            while((i-j) >= 0 && (i+j) < length && s.charAt(i - j) == s.charAt(i + j)) {
                j++;
                count++;
            }

            // Even length
            j = 0;
            while((i-j) >= 0 && (i+j+1) < length && s.charAt(i-j) == s.charAt(i+j+1)) {
                j++;
                count++;
            }
        } 

        return count;
    }
}