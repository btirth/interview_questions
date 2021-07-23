/*

Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
  Input: nums = [1,2,2]
  Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

Example 2:
  Input: nums = [0]
  Output: [[],[0]]
 
Constraints:
  1 <= nums.length <= 10
  -10 <= nums[i] <= 10

*/


class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        subsets(nums, 0, list);
        return ans;
    }
    
    void subsets(int[] nums, int start, List<Integer> list) {
        ans.add(new ArrayList<>(list));
        for(int i=start; i<nums.length; i++) {
            if(i == start || nums[i]!=nums[i-1]) {
                list.add(nums[i]);
                subsets(nums, i+1, list);
                list.remove(list.size()-1);
            }
        }
    }
}
