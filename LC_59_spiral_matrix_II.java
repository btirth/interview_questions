/*

Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

Example 1:
  Input: n = 3
  Output: [[1,2,3],[8,9,4],[7,6,5]]

Example 2:
  Input: n = 1
  Output: [[1]]
 
Constraints:
  1 <= n <= 20

*/


class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int left = 0;
        int right = n-1;
        int up = 0;
        int down = n-1;
        int counter = 1;
        
        while( left <= right && up <= down) {
            for(int i=left; i<right; i++) {
                ans[up][i] = counter++;
            }
            left++;
            
            for(int i=up; i<down; i++) {
                ans[i][right] = counter++;
            }
            up++;
            
            for(int i=right; i>=left; i--) {
                ans[down][i] = counter++;
            }
            right--;
            
            for(int i=down; i>=up;i--) {
                ans[i][left-1] = counter++;
            }
            down--;
        }
        
        if(n%2 == 1) {
            ans[n/2][n/2] = counter;
        }
        
        return ans;
    }
}
