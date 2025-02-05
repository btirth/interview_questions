class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, res, new ArrayList<>());
        return res;
    }

    void helper(int[] nums, int idx, List<List<Integer>> res, List<Integer> curr) {
    
        res.add(new ArrayList<>(curr));
        if(idx == nums.length) {
            return;
        }

        for(int i=idx; i<nums.length; i++) {
            if(i>idx && nums[i] == nums[i-1]) {
                continue;
            }

            curr.add(nums[i]);
            helper(nums, i+1, res, curr);
            curr.remove(curr.size() - 1);
        }
    }
}