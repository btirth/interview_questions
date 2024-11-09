class Solution {
    public long minEnd(int n, int x) {
        long res = x;
        for(int i=1; i<n; i++) {
            res = x | (res + 1);
        }

        return res;
    }
}