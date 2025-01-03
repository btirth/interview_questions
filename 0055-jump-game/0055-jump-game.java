class Solution {
    public boolean canJump(int[] nums) {
        /**
        [2,3,1,1,4]

        4 - true
        1 - true
        1 - true
        3 - true
        2 - true
        
         */

        int n = nums.length;
        int lastGoodIdx = n - 1;
        for(int i=n-2; i>=0; i--) {
            if(lastGoodIdx - i <= nums[i]) {
                lastGoodIdx = i;
            }
        } 

        return lastGoodIdx == 0;
    }
}