class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        for(int i=1; i<=n; i++) {
            if((n-i == 0 || nums[n-i-1] < i) && nums[n-i] >= i) {
                return i;
            }
        }

        return -1;
    }
}