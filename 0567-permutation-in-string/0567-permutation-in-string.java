class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Freq = new int[128];
        int[] s2Freq = new int[128];
        for(char ch: s1.toCharArray()) {
            s1Freq[ch]++;
        }

        int left = 0;
        int right = 0;

        while(right < s2.length()) {
            char ch = s2.charAt(right);
            s2Freq[ch]++;

            if(s2Freq[ch] > s1Freq[ch]) {
                while(s2.charAt(left) != ch) {
                    s2Freq[s2.charAt(left)]--;
                    left++;
                }

                s2Freq[s2.charAt(left)]--;
                left++;
            } 
            
            if(right-left+1 == s1.length()) {
                return true;
            }

            right++;
        }

        return false;
    }
}