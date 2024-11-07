class Solution {
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(n <= 3) {
            return 0;
        }

        int min = nums[n-1] - nums[0];
        // 0 1 2 n-3 n-2 n-1
        // 0 -> n-4, n-3, n-2, n-1
        // 1 -> n-3, n-2, n-1
        // 2 -> n-2, n-1
        // 3 -> n-1
        // 
        for(int i=0; i<=3; i++) {
            for(int j=4-i; j>0; j--) {
                min = Math.min(min, nums[n-j] - nums[i]);
            }
        }

        return min;
    }
}