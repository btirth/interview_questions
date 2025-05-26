class Solution {
    int[][] dp;
    int[] visited;
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        dp = new int[n][26];
        visited = new int[n];

        List<Integer>[] adj = new ArrayList[n];
        for(int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] edge: edges) {
            adj[edge[0]].add(edge[1]);
        }

        for(int i=0; i<n; i++) {
            if(visited[i] == 0) {
                if(helper(adj, i, colors) == -1) {
                    return -1;
                }
            }
        }

        int ans = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<26; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans;
    }

    int helper(List<Integer>[] adj, int idx, String colors) {

        if(visited[idx] == 2) {
            return 1;
        }

        if(visited[idx] == 1) {
            return -1;
        }

        visited[idx] = 1;
        for(int next: adj[idx]) {
            if(helper(adj, next, colors) == -1) {
                return -1;
            }

            for(int i=0; i<26; i++) {
                dp[idx][i] = Math.max(dp[idx][i], dp[next][i]);
            }
        }

        dp[idx][colors.charAt(idx) - 'a'] += 1;
        visited[idx] = 2;
        return 1;
    }
}