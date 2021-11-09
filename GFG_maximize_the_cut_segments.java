/*

Given an integer N denoting the Length of a line segment. You need to cut the line segment in such a way that the cut length of a line segment each time is either x , y or z. Here x, y, and z are integers.
After performing all the cut operations, your total number of cut segments must be maximum.

Example 1:
  Input:
  N = 4
  x = 2, y = 1, z = 1
  Output: 4
  Explanation:Total length is 4, and the cut
  lengths are 2, 1 and 1.  We can make
  maximum 4 segments each of length 1.

Example 2:
  Input:
  N = 5
  x = 5, y = 3, z = 2
  Output: 2
  Explanation: Here total length is 5, and
  the cut lengths are 5, 3 and 2. We can
  make two segments of lengths 3 and 2.

Your Task:
You only need to complete the function maximizeTheCuts() that takes n, x, y, z as parameters and returns max number cuts.

Expected Time Complexity : O(N)
Expected Auxiliary Space: O(N)

Constraints
1 <= N, x, y, z <= 10^4

*/


class Solution
{
    int[] dp;
    
    public int maximizeCuts(int n, int x, int y, int z)
    {
       //Your code here
       dp = new int[n+1];
       Arrays.fill(dp, -1);
       int ans = helper(n, x, y, z);
       if(ans < 0) {
           return 0;
       }
       return ans;
    }
    
    int helper(int n, int x, int y, int z) {
        if(n == 0) {
            return 0;
        }
        
        if(dp[n] != -1) {
            return dp[n];
        }
        
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        int maxZ = Integer.MIN_VALUE;
        
        if(n >= x) {
            maxX = Math.max(maxX, helper(n-x, x, y, z));
        }
        
        if(n >= y) {
            maxY = Math.max(maxX, helper(n-y, x, y, z));
        }
        
        if(n >= z) {
            maxZ = Math.max(maxZ, helper(n-z, x, y, z));
        }
        
        return dp[n] = 1 + Math.max(maxX, Math.max(maxY, maxZ));
    }
}
