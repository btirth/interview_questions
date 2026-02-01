class Solution {
    public int minimumCost(int[] nums) {
        int cost = nums[0];
        int min1 = Math.min(nums[1], nums[2]);
        int min2 = Math.max(nums[1], nums[2]);

        for(int i=3; i<nums.length; i++) {
            if(nums[i] <= min1) {
                min2 = min1;
                min1 = nums[i];
            } else if(nums[i] <= min2) {
                min2 = nums[i];
            }
        }

        return cost + min1 + min2;
    }
}