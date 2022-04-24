/*

Given a 2D integer array circles where circles[i] = [xi, yi, ri] represents the center (xi, yi) and radius ri of the ith circle drawn on a grid, 
return the number of lattice points that are present inside at least one circle.

Note:
  A lattice point is a point with integer coordinates.
  Points that lie on the circumference of a circle are also considered to be inside it.
 
Example 1:
  Input: circles = [[2,2,1]]
  Output: 5
  Explanation:
    The figure above shows the given circle.
    The lattice points present inside the circle are (1, 2), (2, 1), (2, 2), (2, 3), and (3, 2) and are shown in green.
    Other points such as (1, 1) and (1, 3), which are shown in red, are not considered inside the circle.
    Hence, the number of lattice points present inside at least one circle is 5.

Example 2:
  Input: circles = [[2,2,2],[3,4,1]]
  Output: 16
  Explanation:
    The figure above shows the given circles.
    There are exactly 16 lattice points which are present inside at least one circle. 
    Some of them are (0, 2), (2, 0), (2, 4), (3, 2), and (4, 4).


Constraints:
  1 <= circles.length <= 200
  circles[i].length == 3
  1 <= xi, yi <= 100
  1 <= ri <= min(xi, yi)

*/


class Solution {
    
    public int countLatticePoints(int[][] circles) {
        boolean[][] grid = new boolean[202][202];
        
        for(int i=0; i<circles.length; i++) {
            int x = circles[i][0];
            int y = circles[i][1];
            int r = circles[i][2];
            
            for(int j=x-r; j<=x+r; j++) {
                for(int k=y-r; k<=y+r; k++) {
                    if(!grid[j][k] && (j-x)*(j-x) + (k-y)*(k-y) <= r*r) {
                        grid[j][k] = true;
                    }
                }
            }
            
        }
        
        int count = 0;
        for(int i=0; i<202; i++) {
            for(int j=0; j<202; j++) {
                if(grid[i][j]) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
