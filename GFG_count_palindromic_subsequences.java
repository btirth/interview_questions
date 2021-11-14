/*

Given a string str of length N, you have to find number of palindromic subsequence (need not necessarily be distinct) which could be formed from the string str.
Note: You have to return the answer module 109+7;
 

Example 1:
  Input: 
  Str = "abcd"
  Output: 
  4
  Explanation:
  palindromic subsequence are : "a" ,"b", "c" ,"d"
 
Example 2:
  Input: 
  Str = "aab"
  Output: 
  4
  Explanation:
  palindromic subsequence are :"a", "a", "b", "aa"

Your Task:
You don't need to read input or print anything. Your task is to complete the function countPs() which takes a string str as input parameter and returns the number of palindromic subsequence.
 
Expected Time Complexity: O(N*N)
Expected Auxiliary Space: O(N*N)

Constraints:
1<=length of string str <=1000

*/


class Solution
{
    long countPS(String s)
    {
        // Your code here
        long count = 0;
        int mod = 1000000007;
        int n = s.length();
        
        long[][] dp = new long[n][n];
        for(int i=n-1; i>=0; i--) {
            for(int j=i; j<n; j++) {
                if(i == j) {
                    dp[i][j] = 1;
                } else if(i+1 == j) {
                    if(s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = 3;
                    } else {
                        dp[i][j] = 2;
                    }
                } else {
                    if(s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = (1 + dp[i][j-1] + dp[i+1][j]);
                    } else {
                        dp[i][j] = (dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1]);
                    }
                }
                
                dp[i][j]+=mod;
                dp[i][j]%=mod;
            }
        }
        
        return dp[0][n-1]%mod;
        
    }
}
