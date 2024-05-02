class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>());
        return ans;
    }

    void helper(int[] nums, int idx, List<Integer> set) {
        ans.add(new ArrayList<>(set));
        
        for(int i=idx; i<nums.length; i++) {
            if(i>idx && nums[i] == nums[i-1]) {
                continue;
            }

            set.add(nums[i]);
            helper(nums, i+1, set);
            set.remove(set.size()-1);
        }
    }
}