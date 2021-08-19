/*

Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Example 1:
  Input: nums = [1,5,11,5]
  Output: true
  Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:
  Input: nums = [1,2,3,5]
  Output: false
  Explanation: The array cannot be partitioned into equal sum subsets.
 
Constraints:
  1 <= nums.length <= 200
  1 <= nums[i] <= 100

*/



class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i=0; i<n; i++) {
            sum += nums[i];
        }
        
        if(sum%2 == 1) {
            return false;
        }
        
        int amount = sum/2;
        boolean[][] dp = new boolean[n+1][amount+1];
        
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=amount; j++) {
                if(j==0) {
                    dp[i][j] = true;
                } else if(i==0) {
                    dp[i][j] = false;
                } else if(nums[i-1] <= j) {
                    dp[i][j] = dp[i-1][j - nums[i-1]] || dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][amount];
    }
}





class Solution {
    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        int n = nums.length;
        for(int i=0; i<n; i++) {
            sum += nums[i];
        }
        
        if(sum%2 == 1) {
            return false;
        }
        int[][] dp = new int[n][sum];
        for(int i=0; i<n; i++) {
            for(int j=0; j<sum; j++) {
                dp[i][j] = -1;
            }
        }
        return partition(nums, sum/2, 0, dp);
    }
    
    boolean partition(int[] nums, int sum, int i, int[][] dp) {
        if(sum == 0) {
            return true;
        }
        
        if(i>= nums.length || sum < 0) {
            return false;
        }
        
        if(dp[i][sum] != -1) {
            return dp[i][sum] == 1;
        }
        dp[i][sum] = (partition(nums, sum-nums[i], i+1, dp) || partition(nums, sum, i+1, dp)) ? 1 : 0;
        return dp[i][sum] == 1;
    }
}
