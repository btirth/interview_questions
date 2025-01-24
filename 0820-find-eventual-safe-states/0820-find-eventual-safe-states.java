class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer>[] adj = new ArrayList[n];
        int[] indegree = new int[n];

        for(int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i=0; i<n; i++) {
            for(int next: graph[i]) {
                adj[next].add(i);
            }

            indegree[i] = graph[i].length;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            Integer node = q.poll();
           
            for(int prev: adj[node]) {
                indegree[prev]--;

                if(indegree[prev] == 0) {
                    q.add(prev);
                }
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(indegree[i] == 0)
                safeNodes.add(i);
        }

        return safeNodes;
    }
}