class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int n = nums.length;

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int product = nums[i] * nums[j];
                freq.put(product, freq.getOrDefault(product, 0) + 1);
            }
        }

        /**
        with 2 pairs we can generate 8
        3 -> 2 + 2 = 16
        [1,2][1,3][2,3]
        4
        [1,2][1,3][1,4][2,3][2,4][3,4]
        
        (n * (n-1))/2 = 
        
         */
        int ans = 0;
        for(Map.Entry<Integer, Integer> entry: freq.entrySet()) {
            int val = entry.getValue();
            int totalPair = (val * (val - 1))/2;

            ans += totalPair;
        }

        return ans * 8;
    }
}