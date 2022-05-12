/*

Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

Example 1:
  Input: nums = [1,1,2]
  Output:
    [[1,1,2],
     [1,2,1],
     [2,1,1]]

Example 2:
  Input: nums = [1,2,3]
  Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Constraints:
  1 <= nums.length <= 8
  -10 <= nums[i] <= 10

*/


class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        permute(nums, new boolean[nums.length], new ArrayList<Integer>());
        return ans;
    }
    
    void permute(int[] nums, boolean[] visited, List<Integer> currPermutation) {
        if(currPermutation.size() == nums.length) {
            ans.add(new ArrayList<>(currPermutation));
            return;
        }
        
        for(int i=0; i<nums.length; i++) {
            if(visited[i]) {
                continue;
            } 
            
            // avoid permute duplicates
            if(i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            } 
            
            visited[i] = true;
            currPermutation.add(nums[i]);
            permute(nums, visited, currPermutation);
            currPermutation.remove(currPermutation.size()-1);
            visited[i] = false;

        }
    }
}
