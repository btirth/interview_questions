/*

You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:
  The length of the subarray is k, and
  All the elements of the subarray are distinct.

Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.

A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:
  Input: nums = [1,5,4,2,9,9,9], k = 3
  Output: 15
  Explanation: The subarrays of nums with length 3 are:
    - [1,5,4] which meets the requirements and has a sum of 10.
    - [5,4,2] which meets the requirements and has a sum of 11.
    - [4,2,9] which meets the requirements and has a sum of 15.
    - [2,9,9] which does not meet the requirements because the element 9 is repeated.
    - [9,9,9] which does not meet the requirements because the element 9 is repeated.
    We return 15 because it is the maximum subarray sum of all the subarrays that meet the conditions

Example 2:
  Input: nums = [4,4,4], k = 3
  Output: 0
  Explanation: The subarrays of nums with length 3 are:
    - [4,4,4] which does not meet the requirements because the element 4 is repeated.
    We return 0 because no subarrays meet the conditions.
 

Constraints:
  1 <= k <= nums.length <= 10^5
  1 <= nums[i] <= 10^5

*/

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0;
        int l = 0;
        int r = 0;
        long sum = 0;
        boolean[] nc = new boolean[1000001];

        while(r<nums.length) {
            
            if(nc[nums[r]]) {
                while(l<r) {
                    sum -= nums[l];
                    nc[nums[l]] = false;
                    l++;
                    
                    if(l!=r && nums[l] == nums[r]) {
                        sum -= nums[l];
                        nc[nums[l]] = false;
                        l++;
                        break;
                    }                   
                }
            }  
            sum += nums[r];
            nc[nums[r]] = true;
            if(r-l == k-1) {
                maxSum = Math.max(maxSum, sum);
                sum -= nums[l];
                nc[nums[l]] = false;
                l++;
            }
            r++;
        }
        
        return maxSum;
    }
}
