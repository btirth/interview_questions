class Solution {
    public int maxProduct(int[] nums) {
        int max = 1;
        int min = 1;
        int ans = nums[0];

        for(int num: nums) {
            int tempMax = max;
            
            max = Math.max(num, Math.max(max * num, min * num));
            min = Math.min(num, Math.min(min * num, tempMax * num));
            ans = Math.max(ans, Math.max(max, min));
        }

        return ans;
    }
}