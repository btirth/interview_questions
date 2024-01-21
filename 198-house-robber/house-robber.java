class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) {
            return nums[0];
        }

        int n1 = nums[n-1];
        int n2 = Math.max(nums[n-1], nums[n-2]);

        for(int i=n-3; i>=0; i--) {
            int temp = Math.max(nums[i]+n1, n2);
            n1 = n2;
            n2 = temp;
        }

        return Math.max(n1, n2);
    }
}