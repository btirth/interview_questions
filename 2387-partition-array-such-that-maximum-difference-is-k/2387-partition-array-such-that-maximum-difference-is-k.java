class Solution {
    public int partitionArray(int[] nums, int k) {
        int n = nums.length;
        int count = 1;
        int left = 0;
        Arrays.sort(nums);

        for(int i=1; i<n; i++) {
            if(nums[i] - nums[left] > k) {
                count++;
                left = i;
            }
        }

        return count;
    }
}