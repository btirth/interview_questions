class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        } 

        return Math.max(helper(nums, 0, n-2), helper(nums, 1, n-1));
    }

    int helper(int[] nums, int start, int end) {

        if(start == end) {
            return nums[start];
        }

        int n1 = nums[end];
        int n2 = nums[end - 1];

        for(int i=end-2; i>=start; i--) {
            int temp = n2;
            n2 = Math.max(n2, n1 + nums[i]);
            n1 = Math.max(n1, temp);
        }

        return Math.max(n1, n2);
    }
}