/*

Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. 
If target exists, then return its index, otherwise return -1.


Example 1:
    Input: nums = [-1,0,3,5,9,12], target = 9
    Output: 4
    Explanation: 9 exists in nums and its index is 4

Example 2:
    Input: nums = [-1,0,3,5,9,12], target = 2
    Output: -1
    Explanation: 2 does not exist in nums so return -1

*/


class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length-1); 
    }
    
    
    int binarySearch(int[] nums, int target, int start, int last) {
        if(start==last) {
            if(nums[start] == target) return start;
            else return -1;
        }
        int mid = (start+last)/2;
        
        if(nums[mid] == target) {
          return mid;  
        } else if (nums[mid] < target) {
            mid = (mid==last) ? last-1 : mid;
            return binarySearch(nums, target, mid+1, last); 
        } else {
            mid = (mid==start) ? start+1 : mid; 
            return binarySearch(nums, target, start, mid-1); 
        }
    }
}