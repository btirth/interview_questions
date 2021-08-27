/*

The problem is to find shortest distances between every pair of vertices in a given edge weighted directed Graph.
The Graph is represented as adjancency matrix, and the matrix denotes the weight of the edegs (if it exists) else -1. Do it in-place.
 

Example 1:
  Input: matrix = {{0,25},{-1,0}}
  Output: {{0,25},{-1,0}}
  Explanation: The shortest distance between every pair is already given(if it exists).

Example 2:
  Input: matrix = {{0,1,43},{1,0,6},{-1,-1,0}}
  Output: {{0,1,7},{1,0,6},{-1,-1,0}}
  Explanation: We can reach 3 from 1 as 1->2->3 and the cost will be 1+6=7 which is less than 43.
 
Your Task:
  You don't need to read, return or print anything. Your task is to complete the function shortest_distance() which takes the matrix as input parameter and modify the distances for every pair in-place.
 
Expected Time Complexity: O(n^3)
Expected Space Compelxity: O(1)
 
Constraints:
  1 <= n <= 100

*/


class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        // Code here 
        int n = matrix.length;
        for(int i=0; i<n; i++) {
            dist(matrix, i);
        }
    }
    
    void dist(int[][] matrix, int v) {
        int n = matrix.length;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i != v && j != v && matrix[i][v] != -1 && matrix[v][j] != -1) {
                    if(matrix[i][j] == -1) {
                        
                            matrix[i][j] = matrix[i][v] + matrix[v][j];
                        
                        continue;
                    }
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][v] + matrix[v][j]);
                }
            }
        }
    }
}
