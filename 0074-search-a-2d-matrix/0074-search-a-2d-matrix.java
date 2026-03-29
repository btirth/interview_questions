class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = bsRow(matrix, target);
        int n = matrix[0].length;
        if(row < 0 || row >= matrix.length) {
            return false;
        }

        int i = 0;
        int j = n-1;

        while(i <= j) {
            int mid = (j+i) / 2;
            if(matrix[row][mid] == target) {
                return true;
            } else if(matrix[row][mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        return false;
    }

    int bsRow(int[][] matrix, int target) {
        int i = 0;
        int j = matrix.length - 1;
        int n = matrix[0].length;

        while(i <= j) {
            int mid = (j + i) / 2;
            if(matrix[mid][0] <= target && matrix[mid][n-1] >= target) {
                return mid;
            } else if(matrix[mid][0] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        return -1;
    }
}