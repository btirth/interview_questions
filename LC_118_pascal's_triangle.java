/*
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it.
Example:
    Input: 5
    Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/


class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        
        for(int i=1; i<=numRows; i++) {
            prev = curr;
            curr = new ArrayList<>();
            
            for(int j=0; j<i; j++) {
                if(j == 0 || j == i-1) {
                    curr.add(1);
                } else {
                    curr.add(prev.get(j-1) + prev.get(j));
                }
            }
            
            res.add(curr);
        }
        
        return res;
    }
}
