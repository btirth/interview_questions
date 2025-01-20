class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] rowPainted = new int[m];
        int[] colPainted = new int[n];

        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int color = mat[i][j];
                if(!map.containsKey(color)) {
                    map.put(color, new ArrayList<>());
                }

                map.get(color).add(new int[]{i,j});
            }
        }

        for(int i=0; i<arr.length; i++) {
            int color = arr[i];
            List<int[]> cells = map.getOrDefault(color, new ArrayList<>());

            for(int[] cell: cells) {
                rowPainted[cell[0]]++; // 2 1
                colPainted[cell[1]]++; // 1 2

                if(colPainted[cell[1]] == m || rowPainted[cell[0]] == n) {
                    return i;
                }
            }
        }

        return -1;
    }
}