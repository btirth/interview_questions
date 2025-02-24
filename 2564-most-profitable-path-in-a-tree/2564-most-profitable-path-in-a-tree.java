class Solution {
    int[] bobVisited;
    boolean[] aliceVisited;
    boolean bobFound = false;
    int ans = Integer.MIN_VALUE;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        List<Integer>[] adj = new ArrayList[n];

        for(int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
        } 

        for(int[] edge: edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        bobVisited = new int[n];
        aliceVisited = new boolean[n];

        Arrays.fill(bobVisited, -2);

        bobVisit(adj, 0, bob);
        aliceVisit(adj, 0, amount, 0, 0);
        return ans;
    }

    boolean bobVisit(List<Integer>[] adj, int curr, int bob) {
        if(bobFound || bobVisited[curr] != -2) {
            return false;
        }

        if(curr == bob) {
            bobVisited[curr] = 0;
            bobFound = true;
            return true;
        }

        bobVisited[curr] = -1;
        
        for(int next: adj[curr]) {
            if(bobVisit(adj, next, bob)) {
                bobVisited[curr] = bobVisited[next] + 1;
                return true;
            }
        }

        return false;
    }


    void aliceVisit(List<Integer>[] adj, int curr, int[] amount, int step, int reward) {
        if(aliceVisited[curr]) {
            return;
        }

        if(bobVisited[curr] < 0 || bobVisited[curr] > step) {
            reward += amount[curr];
        } else if(bobVisited[curr] == step) {
            reward += (amount[curr] / 2);
        }
        
        aliceVisited[curr] = true;
        boolean isLeaf = true;
        for(int next: adj[curr]) {
            if(!aliceVisited[next]) {
                isLeaf = false;
                aliceVisit(adj, next, amount, step + 1, reward);
            }
        }

        if(isLeaf) {
            ans = Math.max(ans, reward);
        }
    }
}