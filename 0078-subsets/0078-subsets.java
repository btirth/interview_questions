class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return res;
    }

    void backtrack(int[] nums, int idx, List<Integer> subset) {
        if(idx >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        backtrack(nums, idx + 1, subset);
        subset.add(nums[idx]);
        backtrack(nums, idx+1, subset);
        subset.remove(subset.size() - 1);
        
    }
}