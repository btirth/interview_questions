class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, new ArrayList<>(), 0, target);
        return ans;
    }

    void backtrack(int[] candidates, List<Integer> curr, int idx, int target) {
        if(target == 0) {
            if(!ans.contains(curr))
                ans.add(new ArrayList<>(curr));
        }

        if(target <= 0) {
            return;
        }

        for(int i=idx; i<candidates.length; i++) {
            if(i>idx && candidates[i] == candidates[i-1]) {
                continue;
            }
            
            curr.add(candidates[i]);
            backtrack(candidates, curr, i+1, target-candidates[i]);
            curr.remove(curr.size()-1);
            
        }
    }


}