class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int num: nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        helper(nums, freq, new ArrayList<>());
        return ans;
    }

    void helper(int[] nums, HashMap<Integer, Integer> freq, List<Integer> curr) {
        if(curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(Map.Entry<Integer, Integer> entry: freq.entrySet()) {
            if(entry.getValue() > 0) {
                int key = entry.getKey();
                int value = entry.getValue();
                freq.put(key, value - 1);
                curr.add(key);
                helper(nums, freq, curr);
                curr.remove(curr.size() - 1);
                freq.put(key, value);
            }
        }
    }
}