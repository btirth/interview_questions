class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int count = 0;
        int sum = 0;
        freq.put(0,1);
        
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            
            // x + k = sum -> x = sum - k
            count += freq.getOrDefault(sum - k, 0);
            freq.put(sum, freq.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}