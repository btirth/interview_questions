class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    int n;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        n = nums.length;
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>());
        return ans;
    }

    void helper(int[] nums, int idx, List<Integer> list) {
        
            ans.add(new ArrayList<>(list));
           

        for(int i=idx; i<n; i++) {
            if(i>idx && nums[i] == nums[i-1]) {
                continue;
            }
            list.add(nums[i]);
            helper(nums, i+1, list);
            list.remove(list.size() - 1);
        }   
    }
}