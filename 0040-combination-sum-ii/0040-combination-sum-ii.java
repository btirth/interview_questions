class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        backtrack(nums, 0, target, -1, new ArrayList<>());
        return res;
    }

    void backtrack(int[] nums, int idx, int target, int lastSkip, List<Integer> curr) {
        if(target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if(target < 0 || idx == nums.length){ 
            return;
        }

        backtrack(nums, idx + 1, target, nums[idx], curr);
        if(nums[idx] != lastSkip) {
            curr.add(nums[idx]);
            backtrack(nums, idx + 1, target - nums[idx], -1, curr);
            curr.remove(curr.size() - 1);
        }
    }
}