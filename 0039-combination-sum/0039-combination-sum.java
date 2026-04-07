class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>());
        return res;
    }

    void backtrack(int[] cand, int target, int idx, List<Integer> comb) {
        if(target == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }

        if(target < 0 || idx == cand.length) {
            return;
        }

        // Skip the candidate
        backtrack(cand, target, idx+1, comb);
        
        // Take the candidate at index - idx
        comb.add(cand[idx]);
        backtrack(cand, target - cand[idx], idx, comb);
        comb.remove(comb.size() - 1);
    }
}