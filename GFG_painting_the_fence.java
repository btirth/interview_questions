/*

Given a fence with n posts and k colors, find out the number of ways of painting the fence so that not more than two consecutive fences have the same colors. Since the answer can be large return it modulo 10^9 + 7.

Example 1:
  Input:
  N=3,  K=2 
  Output: 6
  Explanation: 
  We have following possible combinations:

Example 2:
  Input:
  N=2,  K=4
  Output: 16

Your Task:
Since, this is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function countWays() that takes n and k as parameters and returns the number of ways in which the fence can be painted.(modulo 109 + 7)

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
  1 ≤ N ≤ 5000
  1 ≤ K ≤ 100

*/


class Solution
{
    long countWays(int n,int k)
    {
        //code here.
        int mod = 1000000007;
        if(n==1) {
            return k;
        }
        long[][] dp = new long[n+1][3];
        dp[2][0] = k;
        dp[2][1] = k*(k-1);
        dp[2][2] = dp[2][0] + dp[2][1];
        
        for(int i=3; i<=n; i++) {
            dp[i][0] = dp[i-1][1];
            dp[i][1] = (dp[i-1][2] * (k-1))%mod;
            dp[i][2] = (dp[i][0] + dp[i][1])%mod;
        }
        
        
        return dp[n][2];
    }
}
