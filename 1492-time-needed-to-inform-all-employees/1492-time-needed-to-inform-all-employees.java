class Solution {
    
    HashMap<Integer, List<Integer>> managerMapping;
    int[] informTime;
    int ans = 0;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        managerMapping = new HashMap<>();
        this.informTime = informTime;
        
        for(int i=0; i<n; i++) {
            List<Integer> subOr = new ArrayList<>();
            if(managerMapping.containsKey(manager[i])) {
                subOr = managerMapping.get(manager[i]);
            }
            subOr.add(i);
            managerMapping.put(manager[i], subOr);
        }

        dfs(headID, 0);
        return ans;
    }

    void dfs(Integer id, int t) {
        if(!managerMapping.containsKey(id)) {
            ans = Math.max(ans, t);
            return;
        }

        for(Integer subOr: managerMapping.get(id)) {
            dfs(subOr, t+informTime[id]);
        }
    }
}