class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n-1;
        int[] ans = new int[n];
        int idx = n-1;
        while(l<=r) {
            if(Math.abs(nums[l]) > Math.abs(nums[r])) {
                ans[idx] = nums[l]*nums[l];
                l++;
            } else {
                ans[idx] = nums[r]*nums[r];
                r--;
            }
            idx--;
        }

        return ans;
    }
}