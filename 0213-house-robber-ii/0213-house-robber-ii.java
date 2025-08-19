class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        if(length == 1) {
            return nums[0];
        } else if(length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(helper(nums, 0, length - 1), helper(nums, 1, length));
    }

    int helper(int[] nums, int start, int end) {
        if(start == end - 1) {
            return nums[start];
        }
        
        int prev2 = nums[end - 1];
        int prev1 = Math.max(nums[end - 1], nums[end - 2]);

        for(int i=end - 3; i >= start; i--) {
            int curr = Math.max(nums[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}