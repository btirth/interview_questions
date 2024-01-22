class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        int[] ans = new int[n];

        for(int i=1; i<=n; i++) {
            for(int j=i+1; j<=n; j++) {
                int dist = j-i;
                dist = Math.min(dist, Math.abs(x-i) + Math.abs(y-j) + 1);
                dist = Math.min(dist, Math.abs(x-j) + Math.abs(y-i) + 1);
                ans[dist-1] += 2;
            }
        }

        return ans;
    }
}