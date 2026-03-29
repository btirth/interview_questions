class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(char ch: s1.toCharArray()) {
            freq1[ch - 'a']++;
        }

        int left = 0;
        int right = 0;
        int n1 = s1.length();
        int n2 = s2.length();

        while(right < n2) {
            char ch = s2.charAt(right);
            freq2[ch - 'a']++;
            
            while(freq2[ch - 'a'] > freq1[ch - 'a']) {
                freq2[s2.charAt(left) - 'a']--;
                left++;
            }
            
            if((right - left + 1) == n1) {
                return true;
            }
        
            right++;
        }

        return false;
    }
}