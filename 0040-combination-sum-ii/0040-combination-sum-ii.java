class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] cand, int target) {
        Arrays.sort(cand);
        helper(cand, 0, target, new ArrayList<>());
        return res;
    }

    void helper(int[] cand, int idx, int target, List<Integer> curr) {
        if(target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if(target < 0 || idx == cand.length) {
            return;
        }

        for(int i=idx; i<cand.length; i++) {
            if(i>idx && cand[i] == cand[i-1]) {
                continue;
            }

            curr.add(cand[i]);
            helper(cand, i+1, target - cand[i], curr);
            curr.remove(curr.size() - 1);
        }
    }
}