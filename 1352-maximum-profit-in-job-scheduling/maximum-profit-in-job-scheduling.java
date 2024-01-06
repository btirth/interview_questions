class Solution {

    public int jobScheduling(int[] startTime, int[] endTime, int[] jobProfit) {
        int n = jobProfit.length;
        int[] dp = new int[n+1];
        int[][] job = new int[n][3];

        for(int i=0; i<n; i++) {
            job[i][0] = startTime[i];
            job[i][1] = endTime[i];
            job[i][2] = jobProfit[i];
        }        

        Arrays.sort(job, (a,b) -> Integer.compare(a[0], b[0]));

        for(int i=n-1; i>=0; i--) {
            int profit = 0;
            for(int j=i+1; j<n; j++) {
                if(job[j][0] >= job[i][1]) {
                    profit = dp[j];
                    break;
                }
            }

            dp[i] = Math.max(profit+job[i][2], dp[i+1]);
        }
        return dp[0];
    }   
}