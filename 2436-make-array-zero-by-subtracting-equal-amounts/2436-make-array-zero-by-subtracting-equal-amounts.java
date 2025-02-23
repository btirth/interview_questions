class Solution {
    public int minimumOperations(int[] nums) {
        /**
        [1,5,0,3,5]
        [0,1,3,5,5] // after sort

        idx = 0
        idx = 1, sum = 1
        idx = 2, sum += (3 - 1) // 3
        idx = 3, sum += (5 - 3) // 5
         */
        Arrays.sort(nums);
        int n = nums.length;
        int sum = 0;
        int ops = 0;

        for(int i=0; i<n; i++) {
            if(nums[i] == 0 || nums[i] <= sum) {
                continue;
            }

            sum += (nums[i] - sum);
            ops++;
        }

        return ops;
    }
}