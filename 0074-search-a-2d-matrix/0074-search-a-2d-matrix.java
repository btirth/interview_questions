class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = binarySearchRow(matrix, target);
        if(row == -1) {
            return false;
        }

        int col = binarySearchCol(matrix, row, target);

        if(col == -1) {
            return false;
        }

        return true;
    }

    int binarySearchRow(int[][] matrix, int target) {
        int up = 0;
        int down = matrix.length - 1;
        int n = matrix[0].length - 1;

        while(up <= down) {
            int mid = (up + down) / 2;
            if(matrix[mid][n] >= target && (mid == 0 || matrix[mid - 1][n] < target)) {
                return mid;
            } else if(matrix[mid][n] > target) {
                down = mid - 1;
            } else {
                up = mid + 1;
            }
        }

        return -1;
    }

    int binarySearchCol(int[][] matrix, int row, int target) {
    
        int left = 0;
        int right = matrix[0].length - 1;
    
        while(left <= right) {
            int mid = (right + left) / 2;
            if(matrix[row][mid] == target) {
                return mid;
            } else if(matrix[row][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
