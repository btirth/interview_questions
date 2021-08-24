/*

We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].

You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.

If you choose a job that ends at time X you will be able to start another job that starts at time X.

Example 1:
  Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
  Output: 120
  Explanation: The subset chosen is the first and fourth job. 
  Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.

Example 2:
  Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
  Output: 150
  Explanation: The subset chosen is the first, fourth and fifth job. 
  Profit obtained 150 = 20 + 70 + 60.

Example 3:
  Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
  Output: 6
 
Constraints:
  1 <= startTime.length == endTime.length == profit.length <= 5 * 10^4
  1 <= startTime[i] < endTime[i] <= 10^9
  1 <= profit[i] <= 10^4

*/


// DP tabular approach
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = getSortedJobs(startTime, endTime, profit);
        
        int n = profit.length;
        int[] dp = new int[n];
        dp[n-1] = jobs[n-1][2];
        
        for(int i=n-2; i>=0; i--) {
            dp[i] = jobs[i][2];
            
            for(int j=i+1; j<n; j++) {
                if(jobs[i][1] > jobs[j][0]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                } else {
                    dp[i] = Math.max(dp[i], jobs[i][2] + dp[j]);
                    break;
                }
            }
        }
        
        return dp[0];
    }
    
    int[][] getSortedJobs(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][3];
        
        for(int i=0; i<startTime.length; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, Comparator.comparingInt(job -> job[0]));
        return jobs;
    }
}





// DP recursive approach
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = getSortedJobs(startTime, endTime, profit);
        int[] startTimes = getStartTimes(jobs);
        return jobScheduling(jobs, startTimes, 0, new HashMap<>());
    }
    
    int[][] getSortedJobs(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][3];
        
        for(int i=0; i<startTime.length; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, Comparator.comparingInt(job -> job[0]));
        return jobs;
    }
    
    int[] getStartTimes(int[][] jobs) {
        int[] startTimes = new int[jobs.length];
        
        for(int i=0; i<jobs.length; i++) {
            startTimes[i] = jobs[i][0];
        }
        
        return startTimes;
    }
    
    int jobScheduling(int[][] jobs, int[] startTimes, int idx, Map<Integer, Integer> profitByJob) {
        if(idx < 0 || idx > startTimes.length-1) {
            return 0;
        }    
        
        if(profitByJob.containsKey(idx)) {
            return profitByJob.get(idx);
        }
        
        int nextIdx = getNextIdx(startTimes, jobs[idx][1]);
        int profitIfScheduled = jobs[idx][2] + jobScheduling(jobs, startTimes, nextIdx, profitByJob);
        int profitIfNotScheduled = jobScheduling(jobs, startTimes, idx+1, profitByJob);;
        int profit = Math.max(profitIfScheduled, profitIfNotScheduled);
        
        profitByJob.put(idx, profit);
        return profit;
    }
    
    int getNextIdx(int[] startTimes, int lastEndingTime) {
        int low = 0;
        int high = startTimes.length-1;
        int nextIdx = startTimes.length;
        
        while(low <= high) {
            int mid = (low+high)/2;
            if(startTimes[mid] >= lastEndingTime) {
                nextIdx = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        
        return nextIdx;
    }
    
}
