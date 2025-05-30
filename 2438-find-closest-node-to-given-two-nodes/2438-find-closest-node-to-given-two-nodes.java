class Solution {
    int[] dist1;
    int[] dist2;
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int currMaxDist = Integer.MAX_VALUE;
        int ans = -1;
        dist1 = new int[n];
        dist2 = new int[n];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);
        dfs(edges, node1, dist1, 0);
        dfs(edges, node2, dist2, 0);

        for(int i=0; i<n; i++) {
            int maxDist = Math.max(dist1[i], dist2[i]);
            if(maxDist < currMaxDist) {
                currMaxDist = maxDist;
                ans = i;
            }
        }

        return ans;
    }

    void dfs(int[] edges, int node, int[] dist, int curr) {
        if(node == -1 || dist[node] != Integer.MAX_VALUE) {
            return;
        }

        dist[node] = curr;
        dfs(edges, edges[node], dist, curr + 1);
    }
}