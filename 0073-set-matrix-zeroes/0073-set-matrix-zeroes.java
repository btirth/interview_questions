class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] rz = new int[m];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == 0) {
                    rz[i] = 1;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i=m-1; i>=0; i--) {
            for(int j=0; j<n; j++) {
                if(rz[i] == 1 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}