class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[]{0,0});
        int totalCost = 0;
        int len = points.length;
        boolean[] visited = new boolean[len];
        
        while(!pq.isEmpty()) {
            int[] pt = pq.poll();
            int idx = pt[0];
            int currCost = pt[1];
            if(visited[idx]) {
                continue;
            }
            visited[idx] = true;
            totalCost += currCost;
            for(int i=0; i<len; i++) {
                if(i != idx && !visited[i]) {
                    int cost = Math.abs(points[idx][0]-points[i][0]) + Math.abs(points[idx][1]-points[i][1]);
                    pq.add(new int[]{i, cost});
                }
            }
        }

        return totalCost;
    }
}