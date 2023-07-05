class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int withoutChanging = 0;
        int withChange = 0;
        int ans = 0;

        for(int i=0; i<n; i++) {
            if(nums[i] == 1) {
                withoutChanging++;
            } else {
                withChange = withoutChanging;
                withoutChanging = 0;
            }

            ans = Math.max(ans, withoutChanging + withChange);
        }

        return ans == n ? n-1 : ans;
    }
}