class Solution {
    List<Integer>[] adj;

    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        adj = new ArrayList[n];

        for(int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                double d = Math.pow(Math.pow(bombs[i][0]-bombs[j][0], 2) + 
                                 Math.pow(bombs[i][1]-bombs[j][1], 2), 0.5);

                if(d <= bombs[i][2]) {
                    adj[i].add(j);
                }

                if(d <= bombs[j][2]) {
                    adj[j].add(i);
                }
            }
        }

        int ans = 0;
        for(int i=0; i<n; i++) {
            ans = Math.max(ans, dfs(i, new boolean[n]));
        }

        return ans;
    }


    int dfs(int idx, boolean[] visited) {
        if(visited[idx]) {
            return 0;
        }

        visited[idx] = true;

        int sum = 1;

        for(int next: adj[idx]) {
            sum += dfs(next, visited);
        }

        return sum;
    }
}