/*

Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:
  Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
  Output: [1,2,3,6,9,8,7,4,5]

Example 2:
  Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
  Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 
Constraints:
  m == matrix.length
  n == matrix[i].length
  1 <= m, n <= 10
  -100 <= matrix[i][j] <= 100

*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int up = 0;
        int down = m-1;
        int left = 0;
        int right = n-1;
        List<Integer> ans = new ArrayList<>();

        while(up<=down && left<=right) {
            // left to right
            if(up<=down && left<=right) {
                for(int i=left; i<=right; i++) {
                    ans.add(matrix[up][i]);
                }
                up++;
            }
            
            // up to down
            if(up<=down && left<=right) {
                 for(int i=up; i<=down; i++) {
                    ans.add(matrix[i][right]);
                }
                right--;
            }
           
            // right to left
            if(up<=down && left<=right) {
                for(int i=right; i>=left; i--) {
                    ans.add(matrix[down][i]);
                }
                down--;
            }
            
            // down to up
            if(up<=down && left<=right) {
                for(int i=down; i>=up; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }

        return ans;
    }
}
