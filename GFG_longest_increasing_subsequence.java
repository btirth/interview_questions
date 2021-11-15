/*

Given an array of integers, find the length of the longest (strictly) increasing subsequence from the given array.

Example 1:
  Input:
    N = 16
    A[]={0,8,4,12,2,10,6,14,1,9,5
         13,3,11,7,15}
  Output: 6
  Explanation:Longest increasing subsequence 0 2 6 9 13 15, which has length 6

Example 2:
  Input:
    N = 6
    A[] = {5,8,3,7,9,1}
  Output: 3
  Explanation:Longest increasing subsequence 5 7 9, with length 3

Your Task:
Complete the function longestSubsequence() which takes the input array and its size as input parameters and returns the length of the longest increasing subsequence.

Expected Time Complexity : O( N*log(N) )
Expected Auxiliary Space: O(N)

Constraints:
  1 ≤ N ≤ 10^5
  0 ≤ A[i] ≤ 10^6

*/


class Solution 
{
    static int longestSubsequence(int size, int a[])
    {
        int LIS = Integer.MIN_VALUE;
        int[] dp = new int[size];
        dp[0] = 1;
        for(int i=1; i<size; i++) {
            dp[i] = 1;
            for(int j=i-1; j>=0; j--) {
                if(a[i] > a[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            LIS = Math.max(LIS, dp[i]);
        }
        
        return LIS;
    }
} 
