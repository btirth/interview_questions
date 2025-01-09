class Solution {
    public long numberOfSubsequences(int[] nums) {
        /**
        in one go -> {q, nums[p] / nums[q]} -> TC O(n^2) 1000*1000 -> 1000000
        in second go
        calculate {nums[]}
        
        
         */
        int n = nums.length;
        long count = 0;
        HashMap<Double, Long> freq = new HashMap<>();
        for(int i=4; i<n; i++) {
            for(int j=i-4; j>=0; j--) {
                double dividsionPair = 1.0 * nums[j] / nums[i-2];
                freq.put(dividsionPair, freq.getOrDefault(dividsionPair, (long)0) + 1);
            }

            for(int j=i+2; j<n; j++) {
                count += freq.getOrDefault(1.0 * nums[j] / nums[i], (long)0);
            }
        }

        return count;
    }
}