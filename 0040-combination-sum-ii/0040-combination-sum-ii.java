class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        res = new ArrayList<>();
        int[] freq = new int[51];
        for(int num: nums) {
            freq[num]++;
        }

        backtrack(1, target, new ArrayList<>(), freq);
        return res;
    }

    public void backtrack(int start, int target, List<Integer> comb, int[] freq) {
        if(target <= 0) {
            if(target == 0)
                res.add(new ArrayList<>(comb));
            return;
        }
        
        for(int key=start; key <= 50; key++) {
            int val = freq[key];
            if(val <= 0) {
                continue;
            }
            
            comb.add(key);
           
            freq[key]--;            
            backtrack(key, target - key, comb, freq);
            comb.remove(comb.size() - 1);
            freq[key]++;
        }
    }
}