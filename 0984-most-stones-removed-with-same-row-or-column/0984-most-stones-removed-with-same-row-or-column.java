class Solution {
    List<Integer>[] adjR = new ArrayList[10001];
    List<Integer>[] adjC = new ArrayList[10001];
    boolean[] visitedR = new boolean[10001];
    boolean[] visitedC = new boolean[10001];

    public int removeStones(int[][] stones) {
        /**
        [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
        
        
        So we will use Union-Find algorithm
        ans = stones - no. of components (ex. parent[i] == i)
        
        Graph question:
        [0,0] -> [0,1]
          |
        [1,0]  

        So we need mapping 
        for stone in stones:
            if !visitedC[stone[1]] && !visitedR[stone[0]]:
                count++
                dfs(i, j)

        dfs(int r, int c) {

            if(!visitedR[r]) {
                // call dfs on all points on row R
                for(int pt: adjR[r]) {
                    dfs(r, pt);
                }
            }

            if(!visitedC[c]) {
                // call dfs on all points on column C
                for(int pt: adjC[c]) {
                    dfs(pt, c);
                }
            }
        }        
         */

        for(int i=0; i<10001; i++) {
            adjR[i] = new ArrayList<>();
            adjC[i] = new ArrayList<>();
        }

        for(int[] stone: stones) {
            int r = stone[0];
            int c = stone[1];

            adjR[r].add(c);
            adjC[c].add(r);
        }

        int stonesToKeep = 0;
        for(int[] stone: stones) {
            int r = stone[0];
            int c = stone[1];

            if(!visitedR[r] && !visitedC[c]) {
                stonesToKeep++;
                dfs(r, c);
            }
        }

        return stones.length - stonesToKeep;
    }

    void dfs(int r, int c) {
    
        if(!visitedR[r]) {
            visitedR[r] = true;
            for(int next: adjR[r]) {
                dfs(r, next);
            }
        }

        if(!visitedC[c]) {
            visitedC[c] = true;
            for(int next: adjC[c]) {
                dfs(next, c);
            }
        }
    }
}