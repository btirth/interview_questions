class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSum(candidates, target, new ArrayList<Integer>(), 0);
        return res;
    }
    
    void combinationSum(int[] candidates, int target, List<Integer> curr, int start) {
        if(target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i=start; i < candidates.length; i++) {
            if(target-candidates[i] >= 0) {
                curr.add(candidates[i]);
                combinationSum(candidates, target-candidates[i], curr, i);
                curr.remove(curr.size()-1);
            }
        }
    }
}