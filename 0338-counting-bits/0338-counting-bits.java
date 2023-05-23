class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        int offset = 1; // offset will be 1,2,4,8,16,...
        
        for(int i=1; i<=n; i++) {
            if(i == (offset*2)) {
                offset = i;
            }

            ans[i] = 1 + ans[i-offset];
        }

        return ans;
    }
}