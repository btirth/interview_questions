class Solution {
    public boolean validPalindrome(String s) {
        return helper(s, 0, s.length() - 1, false);
    }

    boolean helper(String s, int idx1, int idx2, boolean found) {
        if(idx1 >= idx2) {
            return true;
        }

        if(s.charAt(idx1) == s.charAt(idx2)) {
            return helper(s, idx1 + 1, idx2 - 1, found);
        } 

        if(found) {
            return false;
        }
        return helper(s, idx1, idx2 - 1, true) || helper(s, idx1 + 1, idx2, true);
    }
}