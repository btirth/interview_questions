class Solution {
    public int numSplits(String s) {
        int n = s.length();
        int[] left = new int[n];
        int[] right = new int[n];
        
        boolean[] present = new boolean[26];
        int uniqueLetters = 0;

        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            if(!present[ch-'a']) {
                present[ch-'a'] = true;
                uniqueLetters++;
            }

            left[i] = uniqueLetters;
        }

        present = new boolean[26];
        uniqueLetters = 0;
        for(int i=n-1; i>=0; i--) {
            char ch = s.charAt(i);
            if(!present[ch-'a']) {
                present[ch-'a'] = true;
                uniqueLetters++;
            }

            right[i] = uniqueLetters;
        }

        int goodWays = 0;
        for(int i=1; i<n; i++) {
            if(left[i-1] == right[i]) {
                goodWays++;
            }
        } 

        return goodWays;
    }
}