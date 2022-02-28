/*

Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example 1:
Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 4

Example 2:
Input: matrix = [["0","1"],["1","0"]]
Output: 1

Example 3:
Input: matrix = [["0"]]
Output: 0
 
Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 300
matrix[i][j] is '0' or '1'.

*/


class Solution {
    public int maximalSquare(char[][] matrix) {
        int res = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        
        for(int i=0; i<n; i++) {
            if(matrix[m-1][i] == '1') {
                dp[m-1][i] = 1;
                res=1;
            }   
            
        }
        
        for(int i=0; i<m; i++) {
            if(matrix[i][n-1] == '1') {
                dp[i][n-1] = 1;
                res=1;
            }  
            
        }
        
        for(int i=m-2; i>=0; i--) {
            for(int j=n-2; j>=0; j--) {
                if(matrix[i][j] == '0') {
                    dp[i][j] = 0;
                    continue;
                } else {
                    if(dp[i+1][j+1]>0 && dp[i+1][j]>0 && dp[i][j+1]>0) {
                        dp[i][j] = 1 + Math.min(dp[i+1][j+1], Math.min(dp[i+1][j], dp[i][j+1]));
                    } else {
                        dp[i][j] = 1;
                    }
                    
                    res = Math.max(res, dp[i][j]*dp[i][j]);
                }
            }
        }
        
        return res;
    }
}
