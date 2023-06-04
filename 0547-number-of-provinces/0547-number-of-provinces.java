class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(isConnected, i, visited);
                count++;
            }
        }

        return count;
    }

    void dfs(int[][] isConnected, int idx, boolean[] visited) {
        for(int i=0; i<isConnected.length; i++) {
            if(isConnected[idx][i]==1 && !visited[i]) {
                visited[i] = true;
                dfs(isConnected, i, visited);
            }
        }
    }
}