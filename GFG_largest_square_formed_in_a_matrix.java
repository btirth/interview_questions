/*


Given a binary matrix mat of size n * m, find out the maximum size square sub-matrix with all 1s.

Example 1:
  Input: n = 2, m = 2
  mat = {{1, 1}, 
         {1, 1}}
  Output: 2
  Explaination: The maximum size of the square
  sub-matrix is 2. The matrix itself is the 
  maximum sized sub-matrix in this case.

Example 2:
  Input: n = 2, m = 2
  mat = {{0, 0}, 
         {0, 0}}
  Output: 0
  Explaination: There is no 1 in the matrix.

Your Task:
You do not need to read input or print anything. Your task is to complete the function maxSquare() which takes n, m and mat as input parameters and returns the size of the maximum square sub-matrix of given matrix.

Expected Time Complexity: O(n*m)
Expected Auxiliary Space: O(n*m)

Constraints:
  1 ≤ n, m ≤ 50
  0 ≤ mat[i][j] ≤ 1 

*/


class Solution{
   static int maxSquare(int n, int m, int arr[][]){
       int[][] dp=new int[n][m];
    
     
       int ans=0;
       for(int i=n-1;i>=0;i--){
           for(int j=m-1;j>=0;j--){
               if(i==n-1 || j==m-1){
                   dp[i][j]=arr[i][j];
               } else{
                   if(arr[i][j]==0) {
                        dp[i][j]=0;   
                   } else {
                       int min=Math.min(dp[i][j+1],Math.min(dp[i+1][j],dp[i+1][j+1]));
                       dp[i][j]=min+1;
                   }
               }
                
                ans = Math.max(ans, dp[i][j]);
           }
       }
       return ans;
   }
}
