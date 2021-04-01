/*

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

Example 1:
    Input: candidates = [10,1,2,7,6,1,5], target = 8
    Output: 
    [
        [1,1,6],
        [1,2,5],
        [1,7],
        [2,6]
    ]

Example 2:
    Input: candidates = [2,5,2,1,2], target = 5
    Output: 
    [
        [1,2,2],
        [5]
    ]
 
Constraints:
    1 <= candidates.length <= 100
    1 <= candidates[i] <= 50
    1 <= target <= 30

*/


class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        handler(candidates, target, 0, new ArrayList<Integer>());
        return res;
    }
    
    void handler(int[] candidates, int target, int pos, List<Integer> curr) {
        
        if(target == 0) {
            
                res.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i=pos; i<candidates.length && target-candidates[i] >= 0; i++) {
                if(i>pos && candidates[i] == candidates[i-1]) {
                    continue;
                }
                curr.add(candidates[i]);
                handler(candidates, target-candidates[i], i+1, curr);
                curr.remove(curr.size() - 1);
            
        }
    }
}