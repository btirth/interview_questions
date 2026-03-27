class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int n = s.length();
        boolean[] freq = new boolean[128];
        int maxLen = 0;

        while(right < n) {
            char ch = s.charAt(right);

            while(freq[ch]) {
                freq[s.charAt(left)] = false;
                left++;
            }

            freq[ch] = true;

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}