class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = (m*n) - 1;

        /**
        m = 3
        n = 4
        i = 0, j = 11
        mid = 11/2 = 5
        r = ceil(5/n) - 1 = 1
        c = mid - (r * n) = 5 - (1*4) = 1
        
         */
        while(i<=j) {
            int mid = i + (j-i) / 2;
            int r = mid / n;
            int c = mid % n;

            if(matrix[r][c] == target) {
                return true;
            } else if(matrix[r][c] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return false;
    }
}