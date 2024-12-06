class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Binary Search
        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0;
        int bottom = m-1;
        int row = -1;
        while(top <= bottom) {
            int mid = (top + bottom)/2;

            if(target >= matrix[mid][0] && target <= matrix[mid][n-1]) {
                row = mid;
                break;
            } else if(target < matrix[mid][0]) {
                bottom = mid - 1;
            } else if(target > matrix[mid][n-1]) {
                top = mid + 1;
            } else {
                return false;
            }
        }

        if(row == -1) {
            return false;
        }
        
        int left = 0;
        int right = n-1;

        while(left <= right) {
            int mid = (right + left)/2;
            if(target == matrix[row][mid]) {
                return true;
            } else if(target < matrix[row][mid]) {
                right = mid-1;
            } else if(target > matrix[row][mid]) {
                left = mid + 1;
            }
        }

        return false;
    }
}