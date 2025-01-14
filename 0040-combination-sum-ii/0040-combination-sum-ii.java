class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayList<>());
        return ans;
    }

    void helper(int[] cand, int target, int idx, List<Integer> list) {
        if(target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if(target < 0 || idx == cand.length) {
            return;
        }

        // take
        list.add(cand[idx]);
        helper(cand, target - cand[idx], idx+1, list);
        list.remove(list.size() - 1);

        // skip
        while(idx<cand.length-1 && cand[idx] == cand[idx+1]) {
            idx++;
        }
        helper(cand, target, idx + 1, list);
    }
}