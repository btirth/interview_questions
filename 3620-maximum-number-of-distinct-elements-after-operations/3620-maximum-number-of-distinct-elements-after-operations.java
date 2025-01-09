class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) {
            if(i==0 || nums[i-1] < nums[i] - k) {
                nums[i] -= k;
            } else {
                nums[i] = Math.min(nums[i-1]+1, nums[i] + k);
            }
        }

        Arrays.sort(nums);
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            if(i == 0 || nums[i-1] != nums[i]) {
                count++;
            }
        }

        return count;
    }
}