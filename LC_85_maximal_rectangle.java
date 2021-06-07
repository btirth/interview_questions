/*

Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example 1:
  Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
  Output: 6
  Explanation: The maximal rectangle is shown in the above picture.

Example 2:
  Input: matrix = []
  Output: 0

Example 3:
  Input: matrix = [["0"]]
  Output: 0

Example 4:
  Input: matrix = [["1"]]
  Output: 1

Example 5:
  Input: matrix = [["0","0"]]
  Output: 0
 
Constraints:
  rows == matrix.length
  cols == matrix[i].length
  0 <= row, cols <= 200
  matrix[i][j] is '0' or '1'

*/





// Using LC 84 largest rectangle in histogram

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if(n==1) {
            return heights[0];
        }
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = -1;
        for(int i=1; i<n; i++) {
            int p = i-1;
            while(p>=0 && heights[p]>=heights[i]) {
                p=left[p];
            }
            left[i] = p;
        }
        right[n-1] = n;
        for(int i=n-2; i>=0; i--) {
            int p = i+1;
            while(p<n && heights[p]>=heights[i]) {
                p = right[p];
            }
            right[i] = p;
        }
        
        int max = 0;
        for(int i=0; i<n; i++) {
            max = Math.max(max, (right[i]-left[i]-1)*heights[i]);
        }
        return max;
    }
    
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        if(n==0) {
            return 0;
        }
        int m = matrix[0].length;
        int[] bar = new int[m];
        int max = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(matrix[i][j] == '1') {
                    bar[j]++;
                } else {
                    bar[j]=0;
                }
            }
            max = Math.max(max, largestRectangleArea(bar));
        }
        return max;
    }
}
