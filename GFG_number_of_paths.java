/*

The problem is to count all the possible paths from top left to bottom right of a MxN matrix with the constraints that from each cell you can either move to right or down.

Example 1:
  Input:
  M = 3 and N = 3
  Output: 6
  Explanation:
  Let the given input 3*3 matrix is filled 
  as such:
  A B C
  D E F
  G H I
  The possible paths which exists to reach 
  'I' from 'A' following above conditions 
  are as follows:ABCFI, ABEHI, ADGHI, ADEFI, 
  ADEHI, ABEFI
 

Example 2:
  Input:
  M = 2 and N = 8
  Output: 8

Your Task:  
  You don't need to read input or print anything. Your task is to complete the function numberOfPaths() which takes the integer M and integer N as input parameters and returns the number of paths..

Expected Time Complexity: O(m + n - 1))
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ M, N ≤ 10

*/



class Solution{
    
    long numberOfPaths(int a, int b) {
        // Code Here
        long[][] dp = new long[a][b];
        for(int i=0; i<a; i++) {
            dp[i][b-1] = 1;
        }
        
        for(int i=0; i<b; i++) {
            dp[a-1][i] = 1;
        }
        
        for(int i=a-2; i>=0; i--) {
            for(int j=b-2; j>=0; j--) {
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        
        return dp[0][0];
    }
    
}
