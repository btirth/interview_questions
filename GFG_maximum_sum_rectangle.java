/*

Given a 2D matrix M of dimensions RxC. Find the maximum sum subarray in it.

Example 1:
  Input:
    R=4
    C=5
    M=[[1,2,-1,-4,-20],
    [-8,-3,4,2,1],
    [3,8,10,1,3],
    [-4,-1,1,7,-6]]
  Output: 29
  Explanation: The matrix is as follows and the blue rectangle denotes the maximum sum rectangle.

Example 2:
  Input:
    R=2
    C=2
    M=[[-1,-2],[-3,-4]]
  Output: -1
  Explanation: Taking only the first cell is the optimal choice.

Your Task:
You don't need to read input or print anything. Your task is to complete the function maximumSumRectangle() which takes the number R, C, and the 2D matrix M as input parameters and returns the maximum sum subarray.

Expected Time Complexity:O(R*R*C)
Expected Auxillary Space:O(R*C)
 
Constraints:
  1<=R,C<=500
  -1000<=M[i][j]<=1000

*/


class Solution {
    int maximumSumRectangle(int R, int C, int M[][]) {
        // code here
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<R; i++) {
            int[] vector = new int[C];
            for(int j=i; j<R; j++) {
                for(int k=0; k<C; k++) {
                    vector[k] += M[j][k];
                }
                
                ans = Math.max(ans, kadane(vector, C));
            }
        }
        
        return ans;
    }
    
    
    int kadane(int[] arr, int cols) {
        int maxTillNow = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0; i<cols; i++) {
            sum += arr[i];
            maxTillNow = Math.max(maxTillNow, sum);
            
            if(sum < 0) {
                sum = 0;
            }
        }
        
        return maxTillNow;
    }
}
