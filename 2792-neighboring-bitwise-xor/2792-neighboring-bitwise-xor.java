class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        return helper(derived, 1) || helper(derived, 0);
    }

    boolean helper(int[] derived, int prev) {
        int n = derived.length;
        int original = prev;
        for(int i=0; i<n-1; i++) {
            
            if(derived[i] == 1) {
                prev = prev == 1 ? 0 : 1;
            } 
            
        }

        return derived[n-1] == (prev ^ original);
    }
}