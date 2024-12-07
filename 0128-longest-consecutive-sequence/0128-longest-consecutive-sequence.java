class Solution {
    HashMap<Integer, Integer> parent = new HashMap<>();
    HashMap<Integer, Integer> size = new HashMap<>();
    public int longestConsecutive(int[] nums) {
        for(int num: nums) {
            parent.put(num, num);
            size.put(num, 1);
        }

        for(int num: nums) {
            connect(num, num-1);
        }

        int longest = 0;
        for(int num: nums) {
            longest = Math.max(longest, size.get(parent.get(num)));
        }

        return longest;
    }

    int findParent(int node) {
        if(parent.get(node) == node) {
            return node;
        }

        int p = findParent(parent.get(node));
        parent.put(node, p);
        return p;
    }

    void connect(int u, int v) {
        if(!parent.containsKey(v)) {
            return;
        }

        int parentU = findParent(u);
        int parentV = findParent(v);

        if(parentU != parentV) {
            int sizeU = size.get(parentU);
            int sizeB = size.get(parentV);

            if(sizeU >= sizeB) {
                parent.put(parentV, parentU);
                size.put(parentU, size.get(parentU) + size.get(parentV));
            } else {
                parent.put(parentU, parentV);
                size.put(parentV, size.get(parentU) + size.get(parentV));
            }
        }
    }
}