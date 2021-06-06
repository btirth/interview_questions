/*

Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

Example 1:
  Input: nums = [1,3,4,2,2]
  Output: 2

Example 2:
  Input: nums = [3,1,3,4,2]
  Output: 3

Example 3:
  Input: nums = [1,1]
  Output: 1

Example 4:
  Input: nums = [1,1,2]
  Output: 1
 
Constraints:
  2 <= n <= 10^5
  nums.length == n + 1
  1 <= nums[i] <= n
  All the integers in nums appear only once except for precisely one integer which appears two or more times.
 
Follow up:
  How can we prove that at least one duplicate number must exist in nums?
  Can you solve the problem without modifying the array nums?
  Can you solve the problem using only constant, O(1) extra space?

*/


// time complexity O(n) space complexity O(1) with modifying original array
class Solution {
    public int findDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; ++i) {
            int val = Math.abs(nums[i]);
            if(nums[val] < 0){
                return val;
            }
            nums[val] *= -1;
        }
        return 0;
    }
}


// time complexity O(n) space complexity O(n) without modifying original array
class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        if(n==2) {
            return nums[0];
        }
        int[] temp = new int[n+1];
        for(int i=0; i<n; i++) {
            temp[nums[i]] += 1;
        }
        for(int i=1; i<=n; i++) {
            if(temp[i]>1) {
                return i;
            }
        }
        return -1;
    }
}
