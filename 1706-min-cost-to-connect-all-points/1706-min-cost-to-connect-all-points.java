class Solution {
    Set<Integer> visited = new HashSet<>();
    PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.dist, b.dist));

    class Pair{
        int idx;
        int dist;

        Pair(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    int ans = -1;
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        helper(points, 0, 0);
        return ans;
    }

    void helper(int[][] points, int curr, int cost) {
         int n = points.length;
        if(visited.size() == n-1) {
            ans = cost;
            return;
        }

        visited.add(curr);
        int nextPoint = -1;
        int nextPointDist = Integer.MAX_VALUE;
        int[] pt = points[curr];

        for(int i=0; i<n; i++) {
            if(!visited.contains(i)) {
                int dist = Math.abs(points[i][0]-pt[0]) + Math.abs(points[i][1]-pt[1]);
                pq.add(new Pair(i, dist));
                if(nextPointDist > dist) {
                    nextPointDist = dist;
                    nextPoint = i;
                }
            }
        }

        while(!pq.isEmpty()) {
            Pair p = pq.remove();
            if(!visited.contains(p.idx)) {
                if(p.dist < nextPointDist) {
                    nextPoint = p.idx;
                    nextPointDist = p.dist;
                } else {
                    pq.add(p);
                }
                break;
            }
        }

        helper(points, nextPoint, cost+nextPointDist);
    }
}