/*

Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.

Example 1:
  Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
  Output: [1,2,4,7,5,3,6,8,9]

Example 2:
  Input: mat = [[1,2],[3,4]]
  Output: [1,2,3,4]
 
Constraints:
  m == mat.length
  n == mat[i].length
  1 <= m, n <= 10^4
  1 <= m * n <= 10^4
  -10^5 <= mat[i][j] <= 10^5

*/


class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        int[] ans = new int[m*n];
        int idx = 0;
        int i=0, j=0;
        while(true) {
            List<Integer> diag = new ArrayList<>();
            int k = i;
            int l = j;
            
            while(k>=0 && l<n) {
                diag.add(mat[k][l]);
                k--;
                l++;
            }
            
            if((i+j)%2 == 0) {
                while(diag.size() > 0) {
                    ans[idx++] = diag.remove(0);   
                }
            } else {
                while(diag.size() > 0) {
                    ans[idx++] = diag.remove(diag.size()-1);   
                }
            }
            
            if(i<m-1) {
                i++;
            } else if(j<n-1) {
                j++;
            } else {
                break;
            }
        }
        
        return ans;
    }
}
