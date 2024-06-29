class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        Queue<Integer> q = new LinkedList<>();
        int[] degree = new int[n];
        List<Integer>[] adj = new ArrayList[n];
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer>[] ancestors = new HashSet[n];

        for(int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
            ancestors[i] = new HashSet<>();
        }

        for(int[] edge: edges) {
            degree[edge[1]]++;
            adj[edge[0]].add(edge[1]);
        }        

        for(int i=0; i<n; i++) {
            if(degree[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int node = q.poll();
            for(int i: adj[node]) {
            
                degree[i]--;
                if(degree[i] == 0) {
                    q.add(i);
                }

                ancestors[i].addAll(ancestors[node]);
                ancestors[i].add(node);
            }
        }   

        for(int i=0; i<n; i++) {
            List<Integer> list = new ArrayList<>(ancestors[i]);
            Collections.sort(list);
            ans.add(list);
            
        }

        return ans;
    }
}