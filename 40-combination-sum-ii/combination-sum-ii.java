class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ans = new ArrayList<>();
        for(int i=0; i<candidates.length; i++) {
            if(i==0 || candidates[i] != candidates[i-1]) {
                helper(candidates, i, target, new ArrayList<>());
            }
        }
        
        return ans;
    }

    void helper(int[] candidates, int idx, int target, List<Integer> list) {
        if(target-candidates[idx] == 0) {
            list.add(candidates[idx]);
            ans.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }

        if(target < 0) {
            return;
        }

        list.add(candidates[idx]);
        for(int i=idx+1; i<candidates.length; i++) {
            if(i == idx+1 || candidates[i] != candidates[i-1]) {
                helper(candidates, i, target - candidates[idx], list);
            }
        }
        list.remove(list.size()-1);
    }
}