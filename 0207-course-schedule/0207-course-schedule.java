class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[n];
        int[] indegree = new int[n];

        for(int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] pre: prerequisites) {
            adj[pre[1]].add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()) {
            int node = q.poll();
            list.add(node);
            for(int next: adj[node]) {
                indegree[next]--;
                if(indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        return list.size() == n;
    }
}