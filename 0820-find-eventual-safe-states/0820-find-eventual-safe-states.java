class Solution {
    List<Integer> ans = new ArrayList<>();
    int[] visited;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        visited = new int[n];
        for(int i=0; i<graph.length; i++) {
            if(visited[i] == 0) {
                dfs(graph, i);
            }
        }

        Collections.sort(ans);
        return ans;
    }

    boolean dfs(int[][] graph, int idx) {
        if(visited[idx] == 2) {
            return true;
        }

        if(visited[idx] == 1) {
            return false;
        }

        visited[idx] = 1;
        for(int nxt: graph[idx]) {
            if(visited[nxt] != 2 && !dfs(graph, nxt)) {
                return false;
            }
        }

        visited[idx] = 2;
        ans.add(idx);
        return true;
    }
}