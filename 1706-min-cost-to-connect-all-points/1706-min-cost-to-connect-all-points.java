class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int cost = 0;
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        HashSet<Integer> visited = new HashSet<>();
        pq.add(new Integer[]{0,0});
        while(visited.size() < n) {
            Integer[] pt = pq.remove();
            if(visited.contains(pt[1])) {
                continue;
            }

            cost += pt[0];
            visited.add(pt[1]);

            for(int i=0; i<n; i++) {
               if(!visited.contains(i)) {
                   int dist = Math.abs(points[pt[1]][0] - points[i][0]) + Math.abs(points[pt[1]][1] - points[i][1]);
                   pq.add(new Integer[]{dist, i});
               }
            }
        }

        return cost;
    }
}