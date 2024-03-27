class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int ans = 0;
        int prod = 1;
        for(int i=0; i<n; i++) {
            prod *= nums[i];

            while(l<=i && prod >= k) {
                prod /= nums[l++];
            }

            ans += (i-l+1);
        }

        return ans;
    }
}