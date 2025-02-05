class Solution {
    int[] parent;
    int[] rank;
    public int makeConnected(int n, int[][] connections) {
        /**
        We need no. of components to calculate ops to make all computers connected.
        Let's say that we have C components -> We need C extra cables.

        In each components
        - Count no. of cables (cables) and no. of computers (comps) If the node is already visited that menas extra cable
        - To make all computers connected in a network we need (comps - 1) cables
        - So the extra cables = cables - (comps - 1)
        
        at the end ans can be
        - -1 if extra cables < components (C) OR
        - components (C) - 1
        
        DFS on every node if !visited[node]
        - O(n * E)
         */

        int extraCables = 0;
        parent = new int[n];
        rank = new int[n];
        
        for(int i=0; i<n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for(int[] conn: connections) {
            int xPar = getParent(conn[0]);
            int yPar = getParent(conn[1]);

            if(xPar == yPar) {
                extraCables++;
                continue;
            }

            if(rank[xPar] >= rank[yPar]) {
                parent[yPar] = xPar;
                rank[xPar] += rank[yPar];
            } else {
                parent[xPar] = yPar;
                rank[yPar] += rank[xPar];
            }
        }

        int components = 0;
        for(int i=0; i<n; i++) {
            if(parent[i] == i) {
                components++;
            }
        }

        if(extraCables < components - 1) {
            return -1;
        }   

        return components - 1;
    }

    int getParent(int idx) {
        if(idx == parent[idx]) {
            return idx;
        }

        return parent[idx] = getParent(parent[idx]);
    }
}