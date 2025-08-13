class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        /**
        We can 2 assumptions:
        - island is on the edge, so it's directly in the contact of the ocean
        - island has neighbours such that it creates a path to the ocean
        
        Brute Force:
        - Pick each island and check if the it goes to both oceans.
        TC = N * (N * N) = N^3

        - Use memoization

        
        no. of island = N = m * n

        TC = 2N

        Queue pacific;
        Queue atlantic;
        boolean[][] visited;
        int[][] dp // value = 0 -> Not processed, 1 -> water can flow to pacific, 2 -> water can flow to atlantic


        add all island with border with pacific into pacific queue and same with atlantic

        while pacificQ has island:
            island = pacificQ.get
            if visited[island]:
                continue
            dp[island] = 1
            for all 4 neig:
                pacificQ.add(neigh)    


        for each island:
            dp[island] == 2:
                res.add(island)        
         */
        List<List<Integer>> res = new ArrayList<>();
        Queue<int[]> pacificQ = new LinkedList<>();
        Queue<int[]> atlanticQ = new LinkedList<>();
        
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] visited = new boolean[m][n];
        int[][] dp = new int[m][n];

        int[][] directions = new int[][] {
            {0,1},
            {1,0},
            {0,-1},
            {-1,0}
        };

        // Add all the islands from which water can directly flow to pacific and atlantic oceans
        for(int i=0; i<n; i++) {
            pacificQ.add(new int[]{0,i});
            atlanticQ.add(new int[]{m-1, i});
        }

        for(int i=0; i<m; i++) {
            pacificQ.add(new int[]{i,0});
            atlanticQ.add(new int[]{i, n-1});
        }

        // Process island from which water can flow to pacific
        while(!pacificQ.isEmpty()) {
            int[] island = pacificQ.poll();
            int i = island[0];
            int j = island[1];

            if(visited[i][j]) {
                continue;
            }

            visited[i][j] = true;
            dp[i][j] = 1;

            for(int[] dir: directions) {
                int x = i + dir[0];
                int y = j + dir[1];

                if(x<0 || y<0 || x>=m || y>=n || heights[i][j] > heights[x][y] || visited[x][y]) {
                    continue;
                }

                pacificQ.add(new int[]{x,y});
            }
        }

        visited = new boolean[m][n];

        // Process island from which water can flow to atlatic
        while(!atlanticQ.isEmpty()) {
            int[] island = atlanticQ.poll();
            int i = island[0];
            int j = island[1];

            if(visited[i][j]) {
                continue;
            }

            visited[i][j] = true;

            if(dp[i][j] == 1) {
                List<Integer> resultIsland = new ArrayList<>();
                resultIsland.add(i);
                resultIsland.add(j);
                res.add(resultIsland);
            }

            for(int[] dir: directions) {
                int x = i + dir[0];
                int y = j + dir[1];

                if(x<0 || y<0 || x>=m || y>=n || heights[i][j] > heights[x][y] || visited[x][y]) {
                    continue;
                }

                atlanticQ.add(new int[]{x,y});
            }
        }


        return res;
    }
}