class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    int n;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        n = nums.length;
        Arrays.sort(nums);
        ans.add(new ArrayList<>());
        for(int i=0; i<n; i++) {
            if(i>0 && nums[i] == nums[i-1]) {
                continue;
            }

            helper(nums, i, new ArrayList<>());
        }
        

        return ans;
    }

    void helper(int[] nums, int idx, List<Integer> list) {
        if(idx == n) {
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[idx]);
        for(int i=idx + 1; i<=n; i++) {
            if(i<n && i>idx+1 && nums[i] == nums[i-1]) {
                continue;
            }

            helper(nums, i, list);
        }

        list.remove(list.size() - 1);
    }
}