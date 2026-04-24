class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int prev1 = nums[n-1];
        int prev2 = 0;

        for(int i=n-2; i>=0; i--) {
            int temp = prev1;
            prev1 = Math.max(prev2 + nums[i], prev1);
            prev2 = temp;
        }   

        return Math.max(prev1, prev2);
    }
}