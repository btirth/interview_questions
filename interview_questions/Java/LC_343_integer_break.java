/*

Given an integer n, break it into the sum of at least two positive integers and maximize the product of those integers.

Return the maximum product you can get.

Example 1:
    Input: n = 2
    Output: 1
    Explanation: 2 = 1 + 1, 1 × 1 = 1.

Example 2:
    Input: n = 10
    Output: 36
    Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 
Constraints:
    2 <= n <= 58

*/

class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
       
        maxProduct(n, dp);
       
        return dp[n];
    }
    
    int maxProduct(int n, int[] dp) {
        if(dp[n] != 0) {
            return dp[n];
        }
        dp[n] = n-1;
        for(int i=1; i<=n/2; i++) {
            int product = Math.max(i, maxProduct(i, dp))*Math.max(n-i, maxProduct(n-i, dp));
            if(product > dp[n]) {
                dp[n] = product;
            }
        }
        
        return dp[n];
    }
}