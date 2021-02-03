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
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(numRows == 0) {
            return lists;
        }
        List<Integer> curr = new ArrayList<Integer>();
        curr.add(1);
        lists.add(curr);
        for(int i=0; i<numRows-1; i++) {
            List<Integer> prev = curr;
            curr = new ArrayList<Integer>();
            curr.add(1);
            for(int j=0; j<prev.size()-1; j++) {
                int a = prev.get(j) + prev.get(j+1);
                curr.add(a);
            }
            curr.add(1);
            lists.add(curr);
        }
        
        return lists;
    }
}