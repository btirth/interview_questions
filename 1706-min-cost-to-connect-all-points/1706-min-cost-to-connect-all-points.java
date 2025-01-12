class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        int node = 0;
        boolean[] visited = new boolean[n];
        int totalVisited = 0;
        int totalCost = 0;

        while(totalVisited < n) {
            visited[node] = true;
            totalVisited++;
            totalCost += dist[node];

            int nextNode = -1;
    
            for(int i=0; i<n; i++) {
                if(visited[i]) {
                    continue;
                }

                dist[i] = Math.min(dist[i], Math.abs(points[node][0] - points[i][0]) + Math.abs(points[node][1] - points[i][1]));

                if(nextNode == - 1 || dist[nextNode] > dist[i]) {
                    nextNode = i;
                }
            }

            node = nextNode;
        }

        return totalCost;
    }
}