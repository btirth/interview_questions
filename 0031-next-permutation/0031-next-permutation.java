class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int breakPoint = -1;

        for(int i=n-2; i>=0; i--) {
            if(nums[i] < nums[i + 1]) {
                breakPoint = i;
                break;
            }
        }

        if(breakPoint == -1) {
            Arrays.sort(nums);
            return;
        }

        // Find smalles number on right of breakPoint but greater than nums[breakPoint]
        for(int i=n-1; i>breakPoint; i--) {
            if(nums[i]>nums[breakPoint]) {
                int temp = nums[breakPoint];
                nums[breakPoint] = nums[i];
                nums[i] = temp;
                break;       
            }
        }

        // Sort on Right
        int left = breakPoint+1;
        int right = n-1;

        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}