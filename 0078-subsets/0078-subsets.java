class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for(int i=0; i<nums.length; i++) {
            List<List<Integer>> newSubsets = new ArrayList<>();

            for(List<Integer> curr: res) {
                List<Integer> next = new ArrayList<>(curr);
                next.add(nums[i]);
                newSubsets.add(next);
            }

            res.addAll(newSubsets);
        }

        return res;
    }
}