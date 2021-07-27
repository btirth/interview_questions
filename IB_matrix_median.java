/*

Given a matrix of integers A of size N x M in which each row is sorted.

Find an return the overall median of the matrix A.

Note: No extra memory is allowed.

Note: Rows are numbered from top to bottom and columns are numbered from left to right.

Input Format
  The first and only argument given is the integer matrix A.

Output Format
  Return the overall median of the matrix A.

Constraints
  1 <= N, M <= 10^5
  1 <= N*M  <= 10^6
  1 <= A[i] <= 10^9
  N*M is odd

Example 1:
  Input 1:
      A = [   [1, 3, 5],
              [2, 6, 9],
              [3, 6, 9]   ]
  Output 1:
      5
  Explanation 1:
      A = [1, 2, 3, 3, 5, 6, 6, 9, 9]
      Median is 5. So, we return 5.

Example 2:
  Input 2:
      A = [   [5, 17, 100]    ]
  Output 2:
      17 

*/



public class Solution {
    public int findMedian(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int low = 1;
        int high = (int)1e9;

        while(low <= high) {
            int mid  = (low+high) >> 1;
            int cnt = 0;

            for(int i=0; i<n; i++) {
                cnt += helper(A, i, mid);
            }

            if(cnt <= (n*m)/2) {
                low = mid + 1;
            } else {
                high = mid-1;
            }
        } 
        return low;
    }

  
  // count number of element less than mid in given row
    int helper(int[][] A, int row, int n) {
        int low = 0;
        int high = A[row].length-1;

        while(low <= high) {
            int mid = (low+high)>>1;
            if(A[row][mid] <= n) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return low;
    }
}
