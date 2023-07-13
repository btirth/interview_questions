class Solution {
    ArrayList<Integer>[] depenedencies;
    int[] status;
    public boolean canFinish(int n, int[][] pre) {
        status = new int[n]; // 0 - Not visited, 1 - Visiting, 2 - Visited
        depenedencies = new ArrayList[n+1];

        for(int i = 0; i < n; i++){
            depenedencies[i] = new ArrayList<>();
        }

        for(int[] p: pre) {
            depenedencies[p[0]].add(p[1]);
        }

        for(int i=0; i<n; i++) {
            if((status[i] == 0) && !dfs(i)) {
                return false;
            }
        }

        return true;
    }

    boolean dfs(int curr) {
        if(status[curr] != 0) {
            return status[curr] == 2;
        }

        status[curr] = 1;
        for(Integer prev: depenedencies[curr]) {
            if(!dfs(prev)) {
                return false;
            }
        }

        status[curr] = 2;
        return true;
    }
}