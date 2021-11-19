/*

You are given an array A of size N. The array contains integers and is of even length. The elements of the array represent N coin of values V1, V2, ....Vn. You play against an opponent in an alternating way.

In each turn, a player selects either the first or last coin from the row, removes it from the row permanently, and receives the value of the coin.

You need to determine the maximum possible amount of money you can win if you go first.
Note: Both the players are playing optimally.

Example 1:
  Input:
  N = 4
  A[] = {5,3,7,10}
  Output: 15
  Explanation: The user collects maximum value as 15(10 + 5)

Example 2:
  Input:
  N = 4
  A[] = {8,15,3,7}
  Output: 22
  Explanation: The user collects maximum value as 22(7 + 15)

Your Task:
Complete the function maximumAmount() which takes an array arr[] (represent values of N coins) and N as number of coins as a parameter and returns the maximum possible amount of money you can win if you go first.

Expected Time Complexity : O(N*N)
Expected Auxiliary Space: O(N*N)

Constraints:
  2 <= N <= 10^3
  1 <= Ai <= 10^6

*/

class solution
{
    //Function to find the maximum possible amount of money we can win.
    static long countMaximum(int arr[], int n)
    {
        // Your code here
        int[][] dp = new int[n][n];
        
        for(int i=n; i>=0; i--) {
            for(int j=i; j<n; j++) {
                if(i == j) {
                    dp[i][j] = arr[i];
                } else if(i + 1 == j) {
                    dp[i][j] = Math.max(arr[i], arr[j]);
                } else {
                    int val1 = arr[i] + Math.min(dp[i+2][j], dp[i+1][j-1]);
                    int val2 = arr[j] + Math.min(dp[i+1][j-1], dp[i][j-2]);
                    
                    dp[i][j] = Math.max(val1, val2);
                }
            }
        }
        
        return dp[0][n-1];
    }
}
