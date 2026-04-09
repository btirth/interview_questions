class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), -11);
        return res;
    }

    void backtrack(int[] nums, int idx, List<Integer> curr, int lastSkip) {
        if(idx == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        backtrack(nums, idx + 1, curr, nums[idx]);
        if(lastSkip != nums[idx]) {
            curr.add(nums[idx]);
            backtrack(nums, idx + 1, curr, -11);
            curr.remove(curr.size() - 1);
        }
    }
}