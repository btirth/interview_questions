class Solution {
    public long minEnd(int n, int x) {
        /*
        long res = x;
        for(int i=1; i<n; i++) {
            res = x | (res + 1);
        }

        return res;
        */

        long res = x;
        long x_mask = 1;
        long n_mask = 1;
        
        while(n_mask <= n-1) {
            if((x & x_mask) == 0) {
                if((n_mask & (n-1)) > 0) {
                    res |= x_mask;
                }
                n_mask = n_mask << 1;
            }

            x_mask = x_mask << 1;
        }

        return res;
    }
}