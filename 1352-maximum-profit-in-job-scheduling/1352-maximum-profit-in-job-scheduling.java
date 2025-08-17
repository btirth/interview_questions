class Solution {
    int[] dp;
    int length;
    int[][] jobs;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        /**
        Goal: maximum profit

        Constraints:
        - no job overlap
        
        
        0/1 Knapsack problem:
        for every job there's 2 options: do the job or skip

        2^n where n = no. of jobs

        if we use DP (memoization):
        -> If I process a job once, I dont have to do it again.

        take 20, 20
        at 3 -> select 100 -> total -> 120
        skip 3 
            select 4 -> total 20 + 70
            at 6 select 6 -> 20 + 70 + 60
         */
        length = startTime.length;
        jobs = new int[length][3];
        dp = new int[length];
        Arrays.fill(dp, -1);

        for(int i=0; i<length; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, (a,b) -> Integer.compare(a[0], b[0]));

        
        return helper(0);  
    }

    int helper(int idx) {
        if(idx >= length) {
            return 0;
        }

        if(dp[idx] != -1) {
            return dp[idx];
        }

        int profit = 0;
        int next = binarySearch(idx + 1, jobs[idx][1]);
        if(next != -1) {
            profit = Math.max(profit, helper(next));
        }
       
        return dp[idx] = Math.max(profit + jobs[idx][2], helper(idx + 1));
    }

    int binarySearch(int left, int end) {
        int right = length - 1;
        int next = -1;

        while(left <= right) {
            int mid = (right + left) / 2;

            if(jobs[mid][0] >= end) {
                next = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return next;
    }

}