class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates, target, 0, new ArrayList<>());
        return ans;
    }

    void helper(int[] candidates, int target, int idx, List<Integer> comb) {
        if(target == 0) {
            ans.add(new ArrayList<>(comb));
            return;
        }

        if(target < 0) {
            return;
        }

        for(int i=idx; i<candidates.length; i++) {
            comb.add(candidates[i]);
            helper(candidates, target - candidates[i], i, comb);
            comb.remove(comb.size() - 1);
        }
    }
}