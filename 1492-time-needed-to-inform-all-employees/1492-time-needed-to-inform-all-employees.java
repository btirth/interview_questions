class Solution {
    int ans = 0;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        List<Integer>[] subs = new ArrayList[n];
        for (int i = 0; i < subs.length; i++) {
            subs[i] = new ArrayList<>();
        }
        for (int i = 0; i < manager.length; i++) {
            if (i == headID) continue;
            subs[manager[i]].add(i);
        }

        dfs(headID, 0, subs, informTime);
        return ans;
    }

    void dfs(Integer id, int t, List<Integer>[] subs, int[] informTime) {
        if(subs[id].size() == 0 ) {
            ans = Math.max(ans, t);
            return;
        }

        for(Integer subOr: subs[id]) {
            dfs(subOr, t+informTime[id], subs, informTime);
        }
    }
}