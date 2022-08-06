/*

There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).

The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. 
Water can flow from any cell adjacent to an ocean into the ocean.

Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.

Example 1:
  Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
  Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]

Example 2:
  Input: heights = [[2,1],[1,2]]
  Output: [[0,0],[0,1],[1,0],[1,1]]

Constraints:
  m == heights.length
  n == heights[r].length
  1 <= m, n <= 200
  0 <= heights[r][c] <= 10^5

*/


class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        Queue<int[]> pacificQ = new LinkedList<>();
        Queue<int[]> atlanticQ = new LinkedList<>();
        
        for(int i=0; i<m; i++) {
            pacificQ.add(new int[]{i, 0});
            atlanticQ.add(new int[]{i, n-1});
        }
        for(int i=0; i<n; i++) {
            pacificQ.add(new int[]{0, i});
            atlanticQ.add(new int[]{m-1, i});
        }
        
        int[][] directions = {
            {0,1},
            {1,0},
            {-1,0},
            {0,-1}
        };
        
        while(!pacificQ.isEmpty()) {
            int size = pacificQ.size();
            while(size-- > 0) {
                int[] pt = pacificQ.poll();
                pacific[pt[0]][pt[1]] = true;
                
                for(int[] dir: directions) {
                    int x = pt[0]+dir[0];
                    int y = pt[1]+dir[1];
                    if(x>=0 && y>=0 && x<m && y<n && heights[x][y]>=heights[pt[0]][pt[1]] && !pacific[x][y]) {
                        pacificQ.add(new int[]{x,y});
                    }
                }
            }
        }
        
        while(!atlanticQ.isEmpty()) {
            int size = atlanticQ.size();
            while(size-- > 0) {
                int[] pt = atlanticQ.poll();
                atlantic[pt[0]][pt[1]] = true;
                
                for(int[] dir: directions) {
                    int x = pt[0]+dir[0];
                    int y = pt[1]+dir[1];
                    if(x>=0 && y>=0 && x<m && y<n && heights[x][y]>=heights[pt[0]][pt[1]] && !atlantic[x][y]) {
                        atlanticQ.add(new int[]{x,y});
                    }
                }
            }
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    List<Integer> pt = new ArrayList<>();
                    pt.add(i);
                    pt.add(j);
                    ans.add(pt);
                }
            }
        }
        
        return ans;
    }
}
