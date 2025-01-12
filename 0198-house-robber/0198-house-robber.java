class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 1) {
            return nums[0];
        }

        int n1 = nums[len-1];
        int n2 = nums[len-2];

        for(int i=len-3; i>=0; i--) {
            int temp = n2;
            n2 = Math.max(n2, nums[i] + n1);
            n1 = Math.max(n1, temp);
        }

        return Math.max(n1, n2);
    }
}