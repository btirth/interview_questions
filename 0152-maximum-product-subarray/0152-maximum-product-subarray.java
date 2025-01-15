class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int min = nums[0];
        int max = nums[0];
        int n = nums.length;
        for(int i=1; i<n; i++) {
            int temp = min;
            min = Math.min(nums[i]*min, nums[i]*max);
            min = Math.min(nums[i], min);
            max = Math.max(nums[i]*temp, nums[i]*max);
            max = Math.max(nums[i], max);

            ans = Math.max(ans, Math.max(ans, max));
        }

        return ans;
    }
}