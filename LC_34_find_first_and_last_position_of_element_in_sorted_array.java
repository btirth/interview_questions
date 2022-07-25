/*

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

Example 1:
  Input: nums = [5,7,7,8,8,10], target = 8
  Output: [3,4]

Example 2:
  Input: nums = [5,7,7,8,8,10], target = 6
  Output: [-1,-1]

Example 3:
  Input: nums = [], target = 0
  Output: [-1,-1]
 
Constraints:
  0 <= nums.length <= 10^5
  -10^9 <= nums[i] <= 10^9
  nums is a non-decreasing array.
  -10^9 <= target <= 10^9

*/


class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        int left = 0;
        int right = nums.length-1;
        
        while(left <= right) {
            int mid = (left+right)/2;
            if(nums[mid] == target) {
                ans[0] = mid;
                ans[1] = mid;
                while(ans[0] >= 1 && nums[ans[0]-1] == target) {
                    ans[0]--;    
                } 
                while(ans[1] <= nums.length-2 && nums[ans[1]+1] == target) {
                    ans[1]++;
                }
                break;
            } else if(nums[mid] < target) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        
        
        return ans;
    }
}
