/*

Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].

You may return the answer in any order.

Example 1:
    Input: n = 4, k = 2
    Output:
    [
    [2,4],
    [3,4],
    [2,3],
    [1,2],
    [1,3],
    [1,4],
    ]

Example 2:
    Input: n = 1, k = 1
    Output: [[1]]
 
Constraints:
    1 <= n <= 20
    1 <= k <= n

*/


class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        
        combine(1, n, k, new ArrayList<>());
        return res;
    }
    
    void combine(int start, int end, int k, List<Integer> curr) {
        if(k == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i = start; i <= end-k+1; i++) {
            curr.add(i);
            combine(i+1, end, k-1, curr);
            curr.remove(curr.size()-1);
        }
    }
}