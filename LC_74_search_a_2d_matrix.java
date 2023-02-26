/*

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
 
Example 1:
  Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
  Output: true

Example 2:
  Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
  Output: false

Constraints:
  m == matrix.length
  n == matrix[i].length
  1 <= m, n <= 100
  -10^4 <= matrix[i][j], target <= 10^4

*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0;
        int bottom = m-1;

        while(top <= bottom) {
            int mid = (bottom+top)/2;
            if(target > matrix[mid][n-1]) {
                top = mid + 1;
            } else if(target < matrix[mid][0]){
                bottom = mid - 1;
            } else {
                break;
            }
        }

        if(!(top <= bottom)) {
            return false;
        }

        int row = (bottom+top)/2;
        int left = 0;
        int right = n-1;

        while(left <= right) {
            int mid = (right+left)/2;
            if(matrix[row][mid] == target) {
                return true;
            } else if(matrix[row][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
