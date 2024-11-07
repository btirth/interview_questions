class Solution {
    List<Integer>[] adj;
    List<Boolean> hasApple;
    boolean[] visited;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        adj = new ArrayList[n];
        this.hasApple = hasApple;
        visited = new boolean[n];

        for(int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] edge: edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        int minTime = helper(0);
        return minTime == 0 ? 0 : minTime - 2;
    }

    int helper(int idx) {
        if(visited[idx]) {
            return 0;
        }

        visited[idx] = true;
        int totalTime = 0;
        for(int child: adj[idx]) {
            int time = helper(child);
            if(time > 0) {
                totalTime += time;
            }
        }

        return totalTime == 0 && !hasApple.get(idx) ? 0 : totalTime + 2;
    }
}