class Solution {
    int[] parent = new int[20002];
    int[] rank = new int[20002];
    public int removeStones(int[][] stones) {
        /**
        We need to find no. of components
        ans = n - no. of components

        To find no. of components we can use Union Find or DFS
        Union Find is better because of path compression algo

        Now, how we will combine row, col 
        until now we have used Union Find with edge
        Can I say that row - col as edge
        [1...10000][10001...20000]
        So first 10^4 is row and next 10^4 is column
        for stone in stones
            if stone[0], stone[1] not already connected 
                components++
                connect()
         */

        for(int[] stone: stones) {
            int x = stone[0];
            int y = stone[1] + 10001;

            parent[x] = x;
            rank[x] = 2;
            parent[y] = x;
            rank[y] = 1;
        }

        Set<Integer> set = new HashSet<>();

        int components = 0;
        for(int[] stone: stones) {
            int x = stone[0];
            int y = stone[1] + 10001;
            set.add(x);
            set.add(y);
            int pareX = getParent(x);
            int pareY = getParent(y);

            if(pareX == pareY) {
                continue;
            }

            if(rank[pareX] >= rank[pareY]) {
                rank[pareX] += rank[pareY];
                parent[pareY] = pareX;
            } else {
                rank[pareY] += rank[pareX];
                parent[pareX] = pareY;
            }
        }

        for(int node: set) {
            if(getParent(node) == node) {
                components++;
            }
        }   

        return stones.length - components;
    }

    int getParent(int idx) {
        if(parent[idx] == idx) {
            return idx;
        }

        return parent[idx] = getParent(parent[idx]);
    }
}