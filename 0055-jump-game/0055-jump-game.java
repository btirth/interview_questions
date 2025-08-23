class Solution {
    Boolean[] dp;
    public boolean canJump(int[] nums) {
        int len = nums.length;
       int prevBest = len - 1;

       for(int i=len-2; i>=0; i--) {
            if(i + nums[i] >= prevBest) {
                prevBest = i;
            }
       }

       return prevBest == 0;
    }
}