class Solution {
    List<Integer>[] adj;
    boolean[] visited;
    public int countCompleteComponents(int n, int[][] edges) {
        /**
        (n * (n-1))/2
        (3*2)/2 = 6
        (2)/2 = 1
        0
        
        Count the node in a connected graph and no. of edges
        Create edge graph
        for i in n:
            if not visited[i]
                visit(i)


         */

        adj = new ArrayList[n];
        visited = new boolean[n];

        for(int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for(int[] edge: edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        int count = 0;
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                if(isValid(i)) {
                    count++;
                }
            }
        }

        return count;
    }

    boolean isValid(int src) {
        // We will apply BFS
        Queue<Integer> q = new LinkedList<>();
        int nodes = 0;
        int edges = 0;

        q.add(src);

        while(!q.isEmpty()) {
            int size = q.size();

            while(size-- > 0) {
                int node = q.poll();

                if(visited[node]) {
                    continue;
                }

                visited[node] = true;
                nodes++;

                for(int next: adj[node]) {
                    q.add(next);
                    edges++;
                }
            }    
        }

        return edges == ((nodes * (nodes - 1)));
    }
}