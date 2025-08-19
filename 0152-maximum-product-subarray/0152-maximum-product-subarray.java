class Solution {
    public int maxProduct(int[] nums) {
        /**
        min = 0, max = 0
        2 -> min = 2, max = 2
        3 -> min = 1, max = 6
        -2 -> min = -2, max = -2

        max = max(num, max(min * num, max * num));
        min = min(num, min(min * num, max * num));
        
         */
        int minProd = nums[0];
        int maxProd = nums[0];
        int ans = nums[0];

        for(int i=1; i<nums.length; i++) {
            int num = nums[i];
            int tempMinProd = minProd;
            minProd = Math.min(num, Math.min(minProd * num, maxProd * num));
            maxProd = Math.max(num, Math.max(tempMinProd * num, maxProd * num));
            ans = Math.max(ans, Math.max(minProd, maxProd));
        }

        return ans;
    }
}