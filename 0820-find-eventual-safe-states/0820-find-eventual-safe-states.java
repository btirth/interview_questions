class Solution {
    int[] visited;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        int n = graph.length;
        visited = new int[n];
        
        for(int i=0; i<n; i++) {
            if(visited[i] == 0) {
                dfs(graph, i);
            }
        }

        for(int i=0; i<n; i++) {
            if(visited[i] == 2) {
                ans.add(i);
            }
        }

        return ans;
    }

    boolean dfs(int[][] graph, int idx) {
        if(visited[idx] != 0) {
            return visited[idx] == 2;
        }

        visited[idx] = 1;
        for(int nxt: graph[idx]) {
            if(!dfs(graph, nxt)) {
                return false;
            }
        }

        visited[idx] = 2;
        return true;
    }
}