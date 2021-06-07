/*

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example 1:
    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.

Example 2:
    Input: nums = [1]
    Output: 1

Example 3:
    Input: nums = [0]
    Output: 0

Example 4:
    Input: nums = [-1]
    Output: -1

Example 5:
    Input: nums = [-100000]
    Output: -100000
 
Constraints:
    1 <= nums.length <= 3 * 104
    -10^5 <= nums[i] <= 10^5
 

Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

*/


class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int maxValue = nums[0];
        int sum = nums[0];
        
        for(int i=1; i<len; i++) {
            sum = Math.max(nums[i], sum+nums[i]);
        
            if(sum > maxValue) {
                maxValue = sum;
            }
        }
        return maxValue;
    }
}



// Follow up: divide and conquer approach

class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        
        return findSubArray(nums, 0, nums.length-1);
    }
    
    int findSubArray(int[] nums, int start, int end) {
        if(start == end) {
            return nums[start];
        }
        int mid = start + (end - start)/2;
        
        int left = findSubArray(nums, start, mid);
        int right = findSubArray(nums, mid+1, end);
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=mid; i>=start; i--) {
            sum += nums[i];
            leftSum = Math.max(sum, leftSum);
        }
        sum = 0;
        for(int i=mid+1; i<=end; i++) {
            sum += nums[i];
            rightSum = Math.max(sum, rightSum);
        }
        
        int ans = Math.max(left, right);
        
        ans = Math.max(ans, leftSum + rightSum);
        
        return ans;
    }
}
