/*

You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). 
You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). 
You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.

A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.

Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

Example 1:
  Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
  Output: 2
  Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells. This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.

Example 2:
  Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
  Output: 1
  Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than route [1,3,5,3,5].

Example 3:
  Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
  Output: 0
  Explanation: This route does not require any effort.
 
Constraints:
  rows == heights.length
  columns == heights[i].length
  1 <= rows, columns <= 100
  1 <= heights[i][j] <= 10^6

*/


class Cell {
  int x;
  int y;
  Integer difference;

  Cell(int x, int y, Integer difference) {
    this.x = x;
    this.y = y;
    this.difference = difference;
  }
}

class Solution {
  private int directions[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
  
  boolean isValidCell(int x, int y, int row, int col) {
    return x >= 0 && x <= row - 1 && y >= 0 && y <= col - 1;
  }
  
  public int minimumEffortPath(int[][] heights) {
    int row = heights.length;
    int col = heights[0].length;
    int[][] maxAbs = new int[row][col];
    for (int i = 0; i < row; i++)
      Arrays.fill(maxAbs[i], Integer.MAX_VALUE);
    
    maxAbs[0][0] = 0;
    PriorityQueue<Cell> queue = new PriorityQueue<Cell>((a, b)->(a.difference.compareTo(b.difference)));
    
    queue.add(new Cell(0, 0, maxAbs[0][0]));
    
    while(!queue.isEmpty()){
      Cell curr = queue.poll();
      if (curr.x == row-1 && curr.y == col-1){
        return curr.difference;
      }
      for (int[] direction: directions){
        int adjX = curr.x + direction[0];
        int adjY = curr.y + direction[1];
        
        if (!isValidCell(adjX, adjY, row, col))
          continue;
        int currDiff = Math.abs(heights[adjX][adjY] - heights[curr.x][curr.y]);
        int maxDifference = Math.max(currDiff, maxAbs[curr.x][curr.y]);
        if (maxAbs[adjX][adjY] > maxDifference) {
          maxAbs[adjX][adjY] = maxDifference;
          queue.add(new Cell(adjX, adjY, maxDifference));
        }
      }
      
    }
    return maxAbs[row - 1][col - 1];
  }
}
