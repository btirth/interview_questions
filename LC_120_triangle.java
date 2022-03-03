/*
Given a triangle array, return the minimum path sum from top to bottom.
For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
Example 1:
    Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
    Output: 11
    Explanation: The triangle looks like:
        2
       3 4
      6 5 7
     4 1 8 3
    The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
Example 2:
    Input: triangle = [[-10]]
    Output: -10
    
Constraints:
    1 <= triangle.length <= 200
    triangle[0].length == 1
    triangle[i].length == triangle[i - 1].length + 1
    -10^4 <= triangle[i][j] <= 10^4
 
Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?
*/


class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        List<Integer> current = triangle.get(size-1);
        
        for(int j=size-2; j>=0; j--) {
            List<Integer> row = triangle.get(j);

            for(int i=0; i<row.size(); i++) {
                row.set(i, row.get(i)+Math.min(current.get(i), current.get(i+1)));   
            }
            current = row;
        }
        
        return current.get(0);
    }
}




class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> current = triangle.get(0);
        
        for(int i=1; i<triangle.size(); i++) {
            List<Integer> prev = current;
            current = triangle.get(i);
            current.set(0, current.get(0) + prev.get(0));
            int j=1;
            for(; j<current.size()-1; j++) {
                int temp = current.get(j) + Math.min(prev.get(j), prev.get(j-1));
                current.set(j, temp);
            }
            current.set(j, current.get(j)+prev.get(j-1));
        }
        
        int minDist = Integer.MAX_VALUE;
        for(int i=0; i<current.size(); i++) {
            int dist = current.get(i);
            if(dist < minDist) {
                minDist = dist;
            }
        }
        
        return minDist;
    }
}
