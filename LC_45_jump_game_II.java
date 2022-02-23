/*

Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.

Example 1:
  Input: nums = [2,3,1,1,4]
  Output: 2
  Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
  Input: nums = [2,3,0,1,4]
  Output: 2
 
Constraints:
  1 <= nums.length <= 10^4
  0 <= nums[i] <= 1000

*/


class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        
        for(int i=n-2; i>=0; i--) {
            int minJump = Integer.MAX_VALUE;
            for(int j=0; j<nums[i]; j++) {
                if(i+j+1 > n) {
                    dp[i] = 1;
                    continue;
                }
                minJump = Math.min(minJump, dp[i+j+1]);
            }
            if(minJump == Integer.MAX_VALUE) {
                dp[i] = Integer.MAX_VALUE;
            } else {
                dp[i] = minJump + 1;
            }
        }
        
        return dp[0];
    }
}
