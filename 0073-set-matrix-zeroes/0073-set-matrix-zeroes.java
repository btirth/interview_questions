class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] rz = new int[m];
        int[] cz = new int[n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == 0) {
                    rz[i] = 1;
                    cz[j] = 1;
                }
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(rz[i] == 1 || cz[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}