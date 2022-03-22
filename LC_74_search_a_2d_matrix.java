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

// O(m+n logn) time complexity
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int row = -1;
        for(int i=0; i<m; i++) {
            if(target >= matrix[i][0] && target <= matrix[i][n-1]) {
                row = i;
                break;
            }
        }
        
        if(row == -1) {
            return false;
        }
        
        return binarySearch(matrix, target, row);
    }
    
    boolean binarySearch(int[][] matrix, int target, int row) {
        int left = 0;
        int right = matrix[0].length;
        
        while(left <= right) {
            int mid = (left + right)/2;
            
            if(matrix[row][mid] == target) {
                return true;
            } else if(matrix[row][mid] > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        
        return false;
    }
}



// O((n+m) log(n+m)) time complexity
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        return binarySearch(matrix, target, 0, (n*m)-1, m, n);
    }
    
    boolean binarySearch(int[][] matrix, int target, int start, int end, int row, int col) {
        if(start>end) {
            return false;
        }
        int mid = (start+end)/2;
        int i = mid/col;
        int j = mid%col;
        if(matrix[i][j] == target) {
            return true;
        } else if(matrix[i][j] > target) {
            return binarySearch(matrix, target, start, mid-1, row, col);
        } else {
            return binarySearch(matrix, target, mid+1, end, row, col);
        }
    }
}
