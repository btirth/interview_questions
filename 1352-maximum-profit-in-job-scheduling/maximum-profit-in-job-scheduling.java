class Solution {
    int n;
    int[] dp;
    int[][] job;

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        n = profit.length;
        dp = new int[n];
        job = new int[n][3];

        Arrays.fill(dp, -1);
        for(int i=0; i<n; i++) {
            job[i][0] = startTime[i];
            job[i][1] = endTime[i];
            job[i][2] = profit[i];
        }        

        Arrays.sort(job, (a,b) -> Integer.compare(a[0], b[0]));
        return dfs(0);
    }   

    int dfs(int idx) {
        if(idx >= n) {
            return 0;
        }

        if(dp[idx] != -1) {
            return dp[idx];
        }

        int profit = 0;
        
        for(int i=idx+1; i<n; i++) {
            if(job[i][0] >= job[idx][1]) {
                profit = dfs(i);
                break;
            }
        }

        return dp[idx] = Math.max(profit + job[idx][2], dfs(idx+1));
    }                 
}