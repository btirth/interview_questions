class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n + 1];

        for(int i=0; i<n; i++) {
            int min = dp[i] + Math.min(costs[0], Math.min(costs[1], costs[2]));
            
            for(int j=i-1; j>=0; j--) {
                if(days[i] - days[j] < 7) {
                    min = Math.min(dp[j] + costs[1], min);
                } 

                if(days[i] - days[j] < 30) {
                    min = Math.min(dp[j] + costs[2], min);
                } else {
                    break;
                }
            }

            dp[i + 1] = min;
        }

        return dp[n];
    }
}