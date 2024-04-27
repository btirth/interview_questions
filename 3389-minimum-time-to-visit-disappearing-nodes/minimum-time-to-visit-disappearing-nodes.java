class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        // undirected graph, Djikstra Algo
        List<Integer[]>[] adj = new ArrayList[n];
        for(int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] edge: edges) {
            adj[edge[0]].add(new Integer[]{edge[1], edge[2]});
            adj[edge[1]].add(new Integer[]{edge[0], edge[2]});
        }

        for(int i=0; i<n; i++) {
            Collections.sort(adj[i], (a,b) -> Integer.compare(a[1], b[1]));
        }
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        int[] distance = new int[n];
        Arrays.fill(distance, -1);
        pq.add(new Integer[]{0,0});

        while(!pq.isEmpty()) {
            Integer[] edge = pq.poll();
            int node = edge[0];
            int dist = edge[1];
            if(distance[node] != -1 || dist >= disappear[node]) {
                continue;
            }
            distance[node] = dist;
            for(Integer[] nei: adj[node]) {
                int nextNode = nei[0];
                int nextDist = dist + nei[1];
                if(distance[nextNode] == -1 && nextDist < disappear[nextNode]) {
                    pq.add(new Integer[]{nextNode, nextDist});
                }
            }
        }

        for(int i=0; i<n; i++) {
            if(distance[i] > disappear[i]) {
                distance[i] = -1;
            }
        }

        return distance;
    }
}