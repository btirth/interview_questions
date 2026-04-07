class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int idx = 0; idx < nums.length; idx++) {
            List<List<Integer>> nextRes = new ArrayList<>();
            for(List<Integer> curr: res) {
                
                for(int i=0; i<=curr.size(); i++) {
                    List<Integer> next = new ArrayList<>(curr);
                    next.add(i, nums[idx]);
                    nextRes.add(next);
                }
            }

            res = nextRes;
        }

        return res;
    }
}