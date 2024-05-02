class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        
        // 8 = 1<<n = 2^n
        for(int i=0; i<(1<<n); i++) {
            List<Integer> subset = new ArrayList<>();

            for(int j=0; j<n; j++) {
                int bit = 1<<j;
                if((i>>j & 1) == 1) {
                    subset.add(nums[j]);
                }
            }

            ans.add(new ArrayList<>(subset));
        }

        return ans;
    }
}