class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] dp = new int[n+1];
        
        for(int i=0; i<n; i++) {
            dp[i+1] = dp[i]^arr[i];
        }
        
        int idx = 0;
        int[] ans = new int[queries.length];

        for(int[] query: queries) {
            ans[idx] = dp[query[1]+1] ^ dp[query[0]];
            idx++;
        }

        return ans;
    }
}