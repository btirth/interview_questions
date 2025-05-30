class Solution {
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        List<Pair<Integer, Integer>>[] adj = new ArrayList[n];
        List<Pair<Integer, Integer>>[] adjReverse = new ArrayList[n];

        for(int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
            adjReverse[i] = new ArrayList<>();
        }

        for(int[] edge: edges) {
            adj[edge[0]].add(new Pair(edge[1], edge[2]));
            adjReverse[edge[1]].add(new Pair(edge[0], edge[2]));
        }

        long[] dist1 = djikstra(n, adj, src1);
        long[] dist2 = djikstra(n, adj, src2);
        long[] dist3 = djikstra(n, adjReverse, dest);
        long ans = Long.MAX_VALUE;

        for(int i=0; i<n; i++) {
            if(dist1[i] != Long.MAX_VALUE && dist2[i] != Long.MAX_VALUE && dist3[i] != Long.MAX_VALUE)
                ans = Math.min(ans, dist1[i] + dist2[i] + dist3[i]);
        }

        return ans == Long.MAX_VALUE ? -1 : ans;
    }

    long[] djikstra(int n, List<Pair<Integer, Integer>>[] adj, int src) {
        PriorityQueue<Pair<Integer, Long>> pq = new PriorityQueue<>((a,b) -> Long.compare(a.getValue(), b.getValue()));
        pq.add(new Pair(src, (long)0));

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        while(!pq.isEmpty()) {
            Pair<Integer, Long> node = pq.poll();
            long nodeDist = (long)node.getValue();
            int idx = (int)node.getKey();

            if(nodeDist >= dist[idx]) {
                continue;
            }

            dist[idx] = nodeDist;
            for(Pair<Integer, Integer> nei: adj[idx]) {
                int nextIdx = (int)nei.getKey();
                long weight = nei.getValue() + nodeDist;

                if(weight >= dist[nextIdx]) {
                    continue;
                }

                pq.add(new Pair(nextIdx, weight));
            }
        }

        return dist;
    }


}