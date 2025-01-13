class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] adj = new ArrayList[n];
        for(int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] flight: flights) {
            adj[flight[0]].add(new int[]{flight[1], flight[2]});
        }

        int[][] dist = new int[n][k + 2]; 
        for(int i=0; i<n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[]{src, 0, 0});

        while(!pq.isEmpty()) {
            int[] top = pq.poll();
            int node = top[0];
            
            int cost = top[1];
            int stops = top[2];

            if(node == dst) {
                return cost;
            }

            if(dist[node][stops] <= cost || stops == k + 1) {
                continue;
            }

            dist[node][stops] = cost;
            for(int[] nei: adj[node]) {
                int nextNode = nei[0];
                int newCost = cost + nei[1];
                

                if(dist[nextNode][stops + 1] > newCost) {
                    pq.add(new int[]{nextNode, newCost, stops + 1});
                }
            }
        }

        return dist[dst][k] == Integer.MAX_VALUE ? -1 : dist[dst][k];
    }
}