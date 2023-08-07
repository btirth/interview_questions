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