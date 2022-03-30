/*

Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

Example 1:
    Input: candidates = [2,3,6,7], target = 7
    Output: [[2,2,3],[7]]
    Explanation:
        2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
        7 is a candidate, and 7 = 7.
        These are the only two combinations.

Example 2:
    Input: candidates = [2,3,5], target = 8
    Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:
    Input: candidates = [2], target = 1
    Output: []
 
Constraints:
    1 <= candidates.length <= 30
    1 <= candidates[i] <= 200
    All elements of candidates are distinct.
    1 <= target <= 500

*/


class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates, target, 0, new ArrayList<>());
        return ans;
    }
    
    void helper(int[] candidates, int target, int idx, List<Integer> list) {
        if(target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        if(idx >= candidates.length || target < 0) {
            return;
        }
        
        list.add(candidates[idx]);
        helper(candidates, target-candidates[idx], idx, list);
        list.remove(list.size()-1);
        
        helper(candidates, target, idx+1, list);
    }
}



class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSum(candidates, target, new ArrayList<Integer>(), 0);
        return res;
    }
    
    void combinationSum(int[] candidates, int target, List<Integer> curr, int start) {
        if(target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i=start; i < candidates.length; i++) {
            if(target-candidates[i] >= 0) {
                curr.add(candidates[i]);
                combinationSum(candidates, target-candidates[i], curr, i);
                curr.remove(curr.size()-1);
            }
        }
    }
}
