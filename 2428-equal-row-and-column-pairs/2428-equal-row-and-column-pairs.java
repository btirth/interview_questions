class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        HashMap<String, Integer> map = new HashMap<>();
        
        // traverse row
        for(int i=0; i<n; i++) {
            String key = "";
            for(int j=0; j<n; j++) {
                key += (grid[i][j]+"-");
            }

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int count = 0;
        // traverse column
        for(int i=0; i<n; i++) {
            String key = "";
            for(int j=0; j<n; j++) {
                key += (grid[j][i]+"-");
            }

            int val = map.getOrDefault(key, 0);
            count += val;
        }

        return count;
    }
}