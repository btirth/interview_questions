class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        int n = nums.length;
        int maxLen = 0;

        while(right < n) {
            while(left < right && nums[left] + k < nums[right] - k) {
                left++;
            }

            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }

        return maxLen;
    }
}