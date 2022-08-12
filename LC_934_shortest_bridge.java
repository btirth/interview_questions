/*

You are given an n x n binary matrix grid where 1 represents land and 0 represents water.

An island is a 4-directionally connected group of 1's not connected to any other 1's. There are exactly two islands in grid.

You may change 0's to 1's to connect the two islands to form one island.

Return the smallest number of 0's you must flip to connect the two islands.

Example 1:
  Input: grid = [[0,1],[1,0]]
  Output: 1

Example 2:
  Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
  Output: 2

Example 3:
  Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
  Output: 1

Constraints:
  n == grid.length == grid[i].length
  2 <= n <= 100
  grid[i][j] is either 0 or 1.
  There are exactly two islands in grid.

*/


class Solution {
    boolean[][] visited;
    Queue<int[]> q;
    public int shortestBridge(int[][] grid) {
        q = new LinkedList<>();
        int n = grid.length;
        visited = new boolean[n][n];
        helper(grid);
       
        int flips = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int[] pt = q.poll();
                for(int[] dir: directions) {
                    int x = pt[0] + dir[0];
                    int y = pt[1] + dir[1];
                    
                    if(x>=0 && y>=0 && x<n && y<n && !visited[x][y]) {
                         if(grid[x][y] == 1) {
                            return flips;
                        }
                        q.add(new int[]{x,y});
                        visited[x][y] = true;
                       
                    }
                }
            }
            flips++;
        }
        
        return -1;
    }
    
    int[][] directions = {
        {0,1},
        {1,0},
        {0,-1},
        {-1,0}
    };
    
    void helper(int[][] grid) {
        int n = grid.length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    addIslandPts(grid, i, j, q, visited);
                    return;
                }
            }
        }
    }
    
    void addIslandPts(int[][] grid, int i, int j, Queue<int[]> q, boolean[][] visited) {
        q.add(new int[]{i,j});
        visited[i][j] = true;
        for(int[] dir: directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            
            if(x>=0 && y>=0 && x<grid.length && y<grid.length && grid[x][y]==1 && !visited[x][y]) {
                addIslandPts(grid, x, y, q, visited);
            }
        }
    }
}
