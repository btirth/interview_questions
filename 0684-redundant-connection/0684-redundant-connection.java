class Solution {
    int[] rank;
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        rank = new int[n + 1];
        parent = new int[n + 1];

        for(int i=1; i<=n; i++) {
            rank[i] = 1;
            parent[i] = i;
        }

        for(int[] edge: edges) {
            if(!addEdge(edge)) {
                return edge;
            }
        }

        return edges[n-1];
    }

    int getParent(int i) {
        if(parent[i] == i) {
            return i;
        }

        return parent[i] = getParent(parent[i]);
    }

    boolean addEdge(int[] edge) {
        int i = edge[0];
        int j = edge[1];
        int iParent = getParent(i);
        int jParent = getParent(j);

        if(iParent == jParent) {
            return false;
        }

        if(rank[iParent] >= rank[jParent]) {
            parent[jParent] = iParent;
            rank[iParent] += rank[jParent];
        } else {
            parent[iParent] = jParent;
            rank[jParent] += rank[iParent];
        }
        return true;
    }
}