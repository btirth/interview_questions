class Solution {
    int maxLen = 0;
    public int appendCharacters(String s, String t) {
        
        helper(s, t, 0, 0);
        /**
        ti = 2
        t = 6
         */
        return t.length() - maxLen;
    }

    void helper(String s, String t, int si, int ti) {
        if(si == s.length()) {
            maxLen = Math.max(ti, maxLen);
            return;
        } 

        if(ti == t.length()) {
            maxLen = Math.max(ti, maxLen);
            return;
        }

        if(s.charAt(si) == t.charAt(ti)) {
            helper(s, t, si+1, ti+1);
        } else {
            helper(s, t, si+1, ti);
        }
    }
}