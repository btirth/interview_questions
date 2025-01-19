class Solution {
    HashMap<Pair<Integer, Integer>, Boolean> dp;
    public boolean isMatch(String s, String p) {
        dp = new HashMap<>();
        return helper(s, p, 0, 0);
    }

    boolean helper(String s, String p, int idx1, int idx2) {
        if(idx2 == p.length()) {
            return idx1 == s.length();
        }

        if(dp.containsKey(new Pair(idx1, idx2))) {
            return dp.get(new Pair(idx1, idx2));
        }

        dp.put(new Pair(idx1, idx2), true);

        boolean match = idx1 < s.length() && s.charAt(idx1) == p.charAt(idx2);
        if(idx1 < s.length() && p.charAt(idx2) == '.') {
            if(helper(s, p, idx1+1, idx2+1)) {
                return true;
            }
        } 
        
        if(idx2 <= p.length() - 2 && p.charAt(idx2+1) == '*') {
           
                if(helper(s, p, idx1, idx2 + 2)) {
                    return true;
                }
           
                if(idx1 < s.length() && (match || p.charAt(idx2) == '.') && helper(s, p, idx1+1, idx2)) {
                    return true;
                }
            
        } else {
            if(match) {
                if(helper(s, p, idx1+1, idx2+1)) {
                    return true;
                }
            }
        }

        dp.put(new Pair(idx1, idx2), false);
        return false;
    }
}