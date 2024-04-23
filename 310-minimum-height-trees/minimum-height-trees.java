class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) {
            return Arrays.asList(new Integer[]{0});
        }
        List<Integer>[] adj = new ArrayList[n];
        int[] degree = new int[n];

        for(int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] edge: edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        Queue<Integer> leaves = new LinkedList<>();
        for(int i=0; i<n; i++) {
            if(degree[i] == 1) {
                leaves.add(i);
            }
        }

        while(!leaves.isEmpty()) {
            if(n <= 2) {
                break;
            }

            int size = leaves.size();
            while(size-- > 0) {
                int node = leaves.poll();
                n--;
                for(int next: adj[node]) {
                    degree[next]--;
                    if(degree[next] == 1) {
                        leaves.add(next);
                    }
                }
            }
        }

        List<Integer> roots = new ArrayList<>();
        while(!leaves.isEmpty()) {
            roots.add(leaves.poll());
        }
        return roots;
    }
}