class Solution {
    public int countHillValley(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];

        int closestLeft = nums[0];
        int closestRight = nums[len - 1];

        for(int i=1; i<len-1; i++) {
            

            left[i] = closestLeft;

            if(nums[i] != nums[i+1]) {
                closestLeft = nums[i];
            }
            
        }

        for(int i=len-2; i>0; i--) {
            

            right[i] = closestRight;

            if(nums[i] != nums[i - 1]) {
                closestRight = nums[i];
            }
            
        }

        int hillValleyCount = 0;

        for(int i=1; i<len-1; i++) {
            if(nums[i] == nums[i-1]) {
                continue;
            }

            if((left[i] < nums[i] && right[i] < nums[i]) || (left[i] > nums[i] && right[i] > nums[i])) {
                hillValleyCount++;
            }
        }

        return hillValleyCount;
    }
}