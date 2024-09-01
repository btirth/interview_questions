class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m*n != original.length) {
            return new int[][]{};
        }

        int c = 0;
        int r = 0;
        int[][] array2d = new int[m][n];

        for(int num: original) {
            array2d[r][c] = num;
            c++;
            if(c == n) {
                c = 0;
                r++;
            }
        }

        return array2d;
    }
}