/*

You are given a 0-indexed array nums consisting of positive integers. You can choose two indices i and j, such that i != j, and the sum of digits of the number nums[i] is equal to that of nums[j].

Return the maximum value of nums[i] + nums[j] that you can obtain over all possible indices i and j that satisfy the conditions.

Example 1:
  Input: nums = [18,43,36,13,7]
  Output: 54
  Explanation: The pairs (i, j) that satisfy the conditions are:
  - (0, 2), both numbers have a sum of digits equal to 9, and their sum is 18 + 36 = 54.
  - (1, 4), both numbers have a sum of digits equal to 7, and their sum is 43 + 7 = 50.
  So the maximum sum that we can obtain is 54.

Example 2:
  Input: nums = [10,12,19,14]
  Output: -1
  Explanation: There are no two numbers that satisfy the conditions, so we return -1.

Constraints:
  1 <= nums.length <= 10^5
  1 <= nums[i] <= 10^9

*/


class Solution {
    public int maximumSum(int[] nums) {
        int n = nums.length;
        int[][] newNums = new int[n][2];
        
        for(int i=0; i<n; i++) {
            newNums[i][0] = nums[i];
            newNums[i][1] = getSumOfDigits(nums[i]);
        }
        
        Arrays.sort(newNums, (a,b)->(a[1] == b[1] ? a[0]-b[0] : a[1]-b[1]));
        int maxSum= -1;
        for(int i=1; i<n; i++) {
            if(newNums[i][1] == newNums[i-1][1]) {
                maxSum = Math.max(maxSum, newNums[i][0]+newNums[i-1][0]);
            }
        }
        
        return maxSum;
    }
    
    public int getSumOfDigits(int num) {
        int sum = 0;
        while(num>0) {
            sum += num%10;
            num /= 10;
        }
        return sum;
    }
}
