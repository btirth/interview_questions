class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        int length = arr.length;
        int[] dp = new int[length];
        dp[0] = arr[0];
        for(int i=1; i<length; i++) {
            dp[i] = dp[i-1]^arr[i];
        }
        
        int idx = 0;
        for(int[] query: queries) {
            if(query[0] == 0) {
                ans[idx] = dp[query[1]];
            } else {
                ans[idx] = dp[query[1]] ^ dp[query[0]-1];
            }
            
            idx++;
        }

        return ans;
    }
}