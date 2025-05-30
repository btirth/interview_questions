class Solution {
    class Node implements Comparable<Node> {
        int idx;
        int time;
        int fee;

        public Node(int idx, int time, int fee) {
            this.idx = idx;
            this.time = time;
            this.fee = fee;
        }

        public int compareTo(Node node) {
            if(this.time == node.time) {
                return Integer.compare(this.fee, node.fee);
            }

            return Integer.compare(this.time, node.time);
        }
    }

    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int n = passingFees.length;

        int[][] adj = new int[n][n];
        int[] fees = new int[n];
        Arrays.fill(fees, Integer.MAX_VALUE);

        for(int i=0; i<n; i++) {
            Arrays.fill(adj[i], Integer.MAX_VALUE);
        }

        for(int[] edge: edges) {
            adj[edge[0]][edge[1]] = Math.min(adj[edge[0]][edge[1]], edge[2]);
            adj[edge[1]][edge[0]] = Math.min(adj[edge[1]][edge[0]], edge[2]);
        }

        pq.add(new Node(0,0, passingFees[0]));

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            if(fees[node.idx] <= node.fee || node.time > maxTime) {
                continue;
            }

            fees[node.idx] = node.fee;
            for(int i=0; i<n; i++) {
                if(node.idx != i && adj[node.idx][i] != Integer.MAX_VALUE) {
                    pq.add(new Node(i, node.time + adj[node.idx][i], node.fee + passingFees[i]));
                }
            }
        }

        return fees[n-1] == Integer.MAX_VALUE ? -1 : fees[n-1];
    }
}