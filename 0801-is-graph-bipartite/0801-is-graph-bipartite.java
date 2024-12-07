class Solution {
    int[] color;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new int[n];

        for(int i=0; i<n; i++) {
            if(color[i] == 0 && !helper(graph, i, 1)) {
                return false;
            }
        }

        return true;
    }

    boolean helper(int[][] graph, int idx, int clr) {
        if(color[idx] != 0) {
            if(color[idx] != clr) {
                return false;
            }
            return true;
        }

        color[idx] = clr;
        for(int next: graph[idx]) {
            if(!helper(graph, next, clr == 2 ? 1 : 2)) {
                return false;
            }
        }

        return true;
    }
}