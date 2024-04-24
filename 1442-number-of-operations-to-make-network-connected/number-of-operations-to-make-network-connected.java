class Solution {
    int[] parent;
    public int makeConnected(int n, int[][] connections) {
        // to make every nodes connected in a single component we need n-1 edges(cables).
        // step1: find MST (Prim's or Krushkal algo) which will give us no. of components.
        parent = new int[n];
        int[] size = new int[n];
        Arrays.fill(size, 1);
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }

        int extraCables = 0;
        for(int[] conn: connections) {
            int u = conn[0];
            int v = conn[1];
            int uParent = getParent(u);
            int vParent = getParent(v);
            if(uParent == vParent) {
                extraCables++;
            }

            if(size[uParent] > size[vParent]) {
                parent[vParent] = parent[uParent];
                size[uParent] += size[vParent];
            } else {
                parent[uParent] = parent[vParent];
                size[vParent] += size[uParent];
            }
        }

        // Step2: find number of disconnected nodes.
        int connectedCables = connections.length - extraCables;  // this will give us number of cables already connected and required.
        int connectedNodes = 1 + connectedCables; //we need n-1 cables to connect n nodes.
        int disconnectedNodes = n - connectedNodes;

        // Step3: if we have extra cables more than or equal to disconnectedNodes we can connect them otherwise not.
        if(extraCables >= disconnectedNodes) {
            return disconnectedNodes;
        }

        return -1;
    }

    int getParent(int idx) {
        if(parent[idx] == idx) {
            return idx;
        }

        return parent[idx] = getParent(parent[idx]);
    }
}