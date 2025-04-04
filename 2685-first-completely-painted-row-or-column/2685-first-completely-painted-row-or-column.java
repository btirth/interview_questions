class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] rowPainted = new int[m];
        int[] colPainted = new int[n];

        HashMap<Integer, int[]> map = new HashMap<>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                map.put(mat[i][j], new int[]{i,j});
            }
        }

        for(int i=0; i<arr.length; i++) {
            int color = arr[i];
            int[] cell = map.get(color);
            rowPainted[cell[0]]++;
            colPainted[cell[1]]++; 

            if(colPainted[cell[1]] == m || rowPainted[cell[0]] == n) {
                return i;
            }
        }

        return -1;
    }
}