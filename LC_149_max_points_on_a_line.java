/*

Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.

Example 1:
Input: points = [[1,1],[2,2],[3,3]]
Output: 3

Example 2:
Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4

Constraints:
  1 <= points.length <= 300
  points[i].length == 2
  -10^4 <= xi, yi <= 10^4
  All the points are unique.

*/

class Solution {
    public int maxPoints(int[][] points) {
        int res = 1;
        int n = points.length;
        
        for(int i=0; i<n; i++) {
            HashMap<Double, Integer> map = new HashMap<>();
            for(int j=0; j<n; j++) {
                if(i!=j) {
                    double slope = Double.MAX_VALUE;
                    if(points[i][0] != points[j][0]) {
                        slope = ((double)points[i][1]-(double)points[j][1])/((double)points[i][0]-(double)points[j][0]);
                    }
                    
                    int val = map.getOrDefault(slope, 0) + 1;
                    map.put(slope, val);
                    res = Math.max(res, val+1);
                }
            }
        }
        return res;
    }
}
