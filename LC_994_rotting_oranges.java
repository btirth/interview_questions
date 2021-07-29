/*

You are given an m x n grid where each cell can have one of three values:
  0 representing an empty cell,
  1 representing a fresh orange, or
  2 representing a rotten orange.

Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

Example 1:
  Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
  Output: 4

Example 2:
  Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
  Output: -1
  Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

Example 3:
  Input: grid = [[0,2]]
  Output: 0
  Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.

Constraints:
  m == grid.length
  n == grid[i].length
  1 <= m, n <= 10
  grid[i][j] is 0, 1, or 2.

*/


// BFS
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        int fresh = 0;  //total fresh and rotten oranges 
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i,j});
                } 
                if(grid[i][j] != 0) {
                    fresh++;
                }
            }
        }
        if(fresh == 0) {
            return 0;
        }
        
        int minutes = 0;
        int count = 0; //total fresh to rotten orange
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        while(!q.isEmpty()) {
            int size = q.size();
            count+=size;
            for(int j = 0; j<size; j++) {
                int[] point = q.poll();
                for(int i=0; i<4; i++) {
                    int x = dx[i] + point[0];
                    int y = dy[i] + point[1];
                    
                    if(x<0 || y<0 || x>=row || y>=col || grid[x][y] == 0 || grid[x][y] == 2) {
                        continue;
                    }
                    
                    grid[x][y] = 2;
                    q.add(new int[]{x,y});
                }
            }
            
            if(q.size() != 0) {
                minutes++;
            }
            
        }
        
        // if fresh != count that means we left some fresh orange and it's not possible;
        return fresh == count ? minutes : -1;
    }
}
