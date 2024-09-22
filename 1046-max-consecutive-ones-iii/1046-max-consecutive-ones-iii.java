class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int longestOnes = 0;
        int len = nums.length;

        while(right < len) {
            if(nums[right] == 0) {
                if(k>0) {
                    k--;
                } else {
                    while(nums[left] != 0 && left < right) {
                        left++;
                    }

                    left++;
                }
            }

            longestOnes = Math.max(longestOnes, right - left + 1);
            right++;
        }

        return longestOnes;
    }
}