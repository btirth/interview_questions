class Solution {
    public int minReorder(int n, int[][] connections) {
        List<Integer>[] adj = new ArrayList[n];
        List<Integer>[] reverseAdj = new ArrayList[n];
        for(int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
            reverseAdj[i] = new ArrayList<>();
        }

        for(int[] conn: connections) {
            adj[conn[0]].add(conn[1]);
            reverseAdj[conn[1]].add(conn[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int count = 0;
        boolean[] visited = new boolean[n];
        visited[0] = true;
        while(!q.isEmpty()) {
            int node = q.poll();
            for(int next: adj[node]) {
                if(visited[next]) {
                    continue;
                }

                visited[node] = true;
                q.add(next);
                count++;
            }

            for(int next: reverseAdj[node]) {
                if(visited[next]) {
                    continue;
                }
                visited[node] = true;
                q.add(next);
            }
        }

        return count;
    }
}