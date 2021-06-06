/*

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Example 1:
  Input: nums = [3,2,3]
  Output: 3

Example 2:
  Input: nums = [2,2,1,1,1,2,2]
  Output: 2
 
Constraints:
  n == nums.length
  1 <= n <= 5 * 10^4
  -2^31 <= nums[i] <= 2^31 - 1

Follow-up: Could you solve the problem in linear time and in O(1) space?

*/


// Using Moore's Voting Algorithm
// time complexity O(n) and space complexity O(1)
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int last = -1;
        for(int i=0; i<nums.length; i++) {
            if(count == 0) {
                last = nums[i];
            }
            if(nums[i] == last) {
                count++;
            } else {
                count--;
            }
        }
        
        return last;
    }
}
