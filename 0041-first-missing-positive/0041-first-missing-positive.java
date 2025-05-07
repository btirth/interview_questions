class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for(int i=0; i<len; i++) {
            if(nums[i] < 0) {
                nums[i] = 0;
            }
        }

        int i=0;
        while(i<len) {
            if(nums[i] != 0 && nums[i] < len && (i+1) != nums[i] && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        i = 0;
        for(; i<len; i++) {
            if(nums[i] != i+1) {
                return i + 1;
            }
        }

        return len + 1;
    }
}