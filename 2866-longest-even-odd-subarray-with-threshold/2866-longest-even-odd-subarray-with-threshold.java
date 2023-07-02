class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int ans = 0, val = 0; 

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > threshold) {
                val = 0;
            } else if (val > 0 && (nums[i-1]-nums[i]) % 2 != 0) {
                ++val; 
            } else {
                val = 1 - nums[i]%2;
            }

            ans = Math.max(ans, val); 
        }

        return ans; 
    }
}