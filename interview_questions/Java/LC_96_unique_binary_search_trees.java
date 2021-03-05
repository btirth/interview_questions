/*

Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.

Example 1:
    Input: n = 3
    Output: 5

Example 2:
    Input: n = 1
    Output: 1
 
Constraints:
    1 <= n <= 19

*/

class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        for(int i=0; i<=n; i++) {
            dp[i] = -1;
        }
        dp[0] = 1;
        dp[1] = 1;
    
        return tree(n, dp); 
    }
    
    int tree(int n, int[] dp) {
        if(dp[n] != -1) {
            return dp[n];
        }
        int count = 0;    
        for(int i=1; i<=n; i++) {
            count += (tree(i-1, dp) * tree(n-i, dp));
        }
        dp[n] = count;
        return count;
    }
}