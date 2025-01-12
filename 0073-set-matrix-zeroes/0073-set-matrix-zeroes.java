class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] col = new int[n];
        int[] row = new int[m];
        Arrays.fill(col, 1);
        Arrays.fill(row, 1);
        boolean firstRowZero = false;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    if(i > 0) {
                        matrix[i][0] = 0;
                    } else {
                        firstRowZero = true;
                    }
                }
            }
        }

        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(matrix[0][0] == 0) {
            for(int i=0; i<m; i++) {
                matrix[i][0] = 0;
            }
        }

        if(firstRowZero) {
            for(int i=0; i<n; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}