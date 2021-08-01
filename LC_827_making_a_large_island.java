/*

You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.

Return the size of the largest island in grid after applying this operation.

An island is a 4-directionally connected group of 1s.

Example 1:
  Input: grid = [[1,0],[0,1]]
  Output: 3
  Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.

Example 2:
  Input: grid = [[1,1],[1,0]]
  Output: 4
  Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.

Example 3:
  Input: grid = [[1,1],[1,1]]
  Output: 4
  Explanation: Can't change any 0 to 1, only one island with area = 4.
 
Constraints:
  n == grid.length
  n == grid[i].length
  1 <= n <= 500
  grid[i][j] is either 0 or 1.

*/



class Solution {
    public int largestIsland(int[][] grid) {
        if(grid==null || grid.length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int islandID = 2;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    int size = getSize(grid, i, j, islandID);
                    max = Math.max(max, size);
                    
                    map.put(islandID, size);
                    islandID++;    
                }
            }    
        }
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();
                    for(int[] direction : directions) {
                        int x = i + direction[0];
                        int y = j + direction[1];
                        
                        if(x>-1 && y>-1 && x<m && y<n && grid[x][y] != 0) {
                            set.add(grid[x][y]);    
                        }
                    }
                    
                    int sum = 1;
                    for(int k:set) {
                        int value = map.get(k);
                        sum += value;
                    }
                    max = Math.max(max, sum);
                }
            }
        }
        
        return max;
    }
    
    public int getSize(int[][] grid, int i, int j, int islandID) {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        
        grid[i][j] = islandID;
        int left = getSize(grid, i, j-1, islandID);
        int right = getSize(grid, i, j+1, islandID);
        int up = getSize(grid, i-1, j, islandID);
        int down = getSize(grid, i+1, j, islandID);
        
        return left+right+up+down+1;
    }
}
