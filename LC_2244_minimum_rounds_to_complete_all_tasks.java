/*

You are given a 0-indexed integer array tasks, where tasks[i] represents the difficulty level of a task. In each round, you can complete either 2 or 3 tasks of the same difficulty level.

Return the minimum rounds required to complete all the tasks, or -1 if it is not possible to complete all the tasks.

Example 1:
  Input: tasks = [2,2,3,3,2,4,4,4,4,4]
  Output: 4
  Explanation: To complete all the tasks, a possible plan is:
    - In the first round, you complete 3 tasks of difficulty level 2. 
    - In the second round, you complete 2 tasks of difficulty level 3. 
    - In the third round, you complete 3 tasks of difficulty level 4. 
    - In the fourth round, you complete 2 tasks of difficulty level 4.  
    It can be shown that all the tasks cannot be completed in fewer than 4 rounds, so the answer is 4.

Example 2:
  Input: tasks = [2,3,3]
  Output: -1
  Explanation: There is only 1 task of difficulty level 2, but in each round, you can only complete either 2 or 3 tasks of the same difficulty level. 
    Hence, you cannot complete all the tasks, and the answer is -1.

Constraints:
  1 <= tasks.length <= 10^5
  1 <= tasks[i] <= 10^9

*/


class Solution {
    public int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        int ans = 0;
        int countSameDiffLevel = 1;
    
        for(int i=1; i<=tasks.length; i++) {
            if(i == tasks.length || tasks[i] != tasks[i-1]) {
                if(countSameDiffLevel == 1) {
                    return -1;
                } else if(countSameDiffLevel%3 == 0) {
                    ans += countSameDiffLevel/3;
                } else {
                    ans += 1 + countSameDiffLevel/3;
                }
                countSameDiffLevel = 0;
            } 
            countSameDiffLevel++;
            
        }
        
        return ans;
    }
}



// Using DP
class Solution {
    public int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        int ans = 0;
        int countSameDiffLevel = 1;
        int[] dp = new int[tasks.length + 1];
        Arrays.fill(dp, -1);
        fillDP(dp);
        for(int i=1; i<=tasks.length; i++) {
            if(i == tasks.length || tasks[i] != tasks[i-1]) {
                if(dp[countSameDiffLevel] == -1) {
                    return -1;
                }
                ans += dp[countSameDiffLevel];
                countSameDiffLevel = 0;
            } 
            countSameDiffLevel++;
            
        }
        
        return ans;
    }
    
    void fillDP(int[] dp) {
        dp[0] = 0;
        for(int i=2; i<dp.length; i++) {
            if(dp[i-2] >= 0) {
                dp[i] = 1 + dp[i-2];
            }
        }
        
        for(int i=3; i<dp.length; i++) {
            if(dp[i-3] >= 0) {
                if(dp[i] == -1) {
                    dp[i] = dp[i-3] + 1;
                } else {
                    dp[i] = Math.min(dp[i], 1 + dp[i-3]);
                }
            }
        }
    }
}
