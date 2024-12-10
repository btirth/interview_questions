class Solution {
    HashMap<String, Integer> freq = new HashMap<>();
    int maxLen = 0;

    public int maximumLength(String s) {
        int l = 0;
        int r = 0;

        while(r < s.length()) {
            if(s.charAt(l) != s.charAt(r)) {
                l++;
                while(l < r) {
                    helper(s, l, r);
                    l++;
                }
            } 

            helper(s, l, r+1);
            if(r-l >= 2)
                maxLen = Math.max(maxLen, r-l+1-2);
            r++;
        }

        return maxLen == 0 ? -1 : maxLen;
    }

    void helper(String s, int l, int r) {
        String substr = s.substring(l, r);
        freq.put(substr, freq.getOrDefault(substr, 0) + 1);

        if(freq.get(substr) >= 3) {
            maxLen = Math.max(maxLen, substr.length());
        }
    }
}