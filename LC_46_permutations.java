/*

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Example 1:
  Input: nums = [1,2,3]
  Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:
  Input: nums = [0,1]
  Output: [[0,1],[1,0]]

Example 3:
  Input: nums = [1]
  Output: [[1]]
 
Constraints:
  1 <= nums.length <= 6
  -10 <= nums[i] <= 10
  All the integers of nums are unique.


*/


class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        permute(nums, 0);
        return ans;
    }
    
    public void permute(int[] nums, int idx) {
        if(idx == nums.length) {
            List<Integer> list = new ArrayList<Integer>();
            for(int i=0; i<nums.length; i++) {
                list.add(nums[i]);
            }
            
            ans.add(list);
        }
        
        for(int i=idx; i<nums.length; i++) {
            swap(nums, i, idx);
            permute(nums, idx+1);
            swap(nums, idx, i);
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
