class Solution {
    class Pair implements Comparable<Pair>{
        int node;
        double prob;

        Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }

        public int compareTo(Pair p) {
            return Double.compare(this.prob, p.prob);
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        int[] maxProb = new int[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        List<Pair>[] adj = new ArrayList[n];
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i=0; i<edges.length; i++) {
            int[] edge = edges[i];
            adj[edge[0]].add(new Pair(edge[1], succProb[i]));
            adj[edge[1]].add(new Pair(edge[0], succProb[i]));
        }

        pq.add(new Pair(start, 1));
        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            if(visited[p.node]) {
                continue;
            }

            visited[p.node] = true;
            double prob = p.prob;
            if(p.node == end) {
                return prob;
            }

            for(Pair next: adj[p.node]) {
                pq.add(new Pair(next.node, prob * next.prob));
            }
        }

        return 0.0;
    }
}