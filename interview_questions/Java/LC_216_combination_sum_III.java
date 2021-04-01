/*

Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

Example 1:
    Input: k = 3, n = 7
    Output: [[1,2,4]]
    Explanation:
        1 + 2 + 4 = 7
        There are no other valid combinations.

Example 2:
    Input: k = 3, n = 9
    Output: [[1,2,6],[1,3,5],[2,3,4]]
    Explanation:
        1 + 2 + 6 = 9
        1 + 3 + 5 = 9
        2 + 3 + 4 = 9
        There are no other valid combinations.

Example 3:
    Input: k = 4, n = 1
    Output: []
    Explanation: There are no valid combinations. [1,2,1] is not valid because 1 is used twice.

Example 4:
    Input: k = 3, n = 2
    Output: []
    Explanation: There are no valid combinations.

Example 5:
    Input: k = 9, n = 45
    Output: [[1,2,3,4,5,6,7,8,9]]
    Explanation:
        1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 = 45
        ​​​​​​​There are no other valid combinations.
    
Constraints:
    2 <= k <= 9
    1 <= n <= 60

*/


class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        handler(k, n, 0, new ArrayList<Integer>());
        return res;
    }
    
    void handler(int k, int target, int pos, List<Integer> curr) {
        if(k == 0 && target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        
        if(k == 0 || target == 0) {
            return;
        }
        
        for(int i=pos+1; i<10-k+1; i++) {
            if(target - i >= 0) {
                curr.add(i);
                handler(k-1, target-i, i, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }
}