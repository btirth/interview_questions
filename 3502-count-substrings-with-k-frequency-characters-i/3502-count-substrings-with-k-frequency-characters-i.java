class Solution {
    public int numberOfSubstrings(String s, int k) {
        /**
        abacbc
        aba
        abac

         */

        int left = 0;
        int right = 0;
        int n = s.length();
        int[] freq = new int[26];
        int ans = 0;

        while(right < n) {
            char ch = s.charAt(right);
            freq[ch - 'a']++;
            if(freq[ch - 'a'] == k) {                
                while(freq[ch - 'a'] >= k) {
                    freq[s.charAt(left) - 'a']--;
                    ans += (n - right);
                    left++;
                }
            }

            right++;
        } 

        return ans;
    }
}