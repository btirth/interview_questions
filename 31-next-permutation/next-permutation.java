class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        // step1 - find the turning point
        int idx = -1;
        for(int i=n-2; i>=0; i--) {
            if(nums[i] < nums[i+1]) {
                idx = i;
                break;
            }
        }

        if(idx == -1) {
            Arrays.sort(nums);
            return;
        }

        // step2 - find the smallest element from the selected point's right side.
        for(int i=n-1; i>idx; i--) {
            if(nums[i]>nums[idx]) {
                int temp = nums[idx];
                nums[idx] = nums[i];
                nums[i] = temp;
                break;       
            }
        }

        // step3 - sort the remaining elements on the right side.
        int left = idx+1;
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