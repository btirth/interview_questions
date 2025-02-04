class Solution {
    public int maxAscendingSum(int[] nums) {
        int sum = nums[0];
        int ans = nums[0];
        int n = nums.length;

        for(int i=1; i<n; i++) {
            if(nums[i] <= nums[i-1]) {
                ans = Math.max(ans, sum);
                sum = 0;
            }

            sum += nums[i];
        }

        ans = Math.max(ans, sum);
        return ans;
    }
}