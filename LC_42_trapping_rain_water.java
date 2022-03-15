/*

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:
  Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
  Output: 6
  Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

Example 2:
  Input: height = [4,2,0,3,2,5]
  Output: 9
 
Constraints:
  n == height.length
  0 <= n <= 3 * 10^4
  0 <= height[i] <= 10^5

*/



// O(n) time and O(1) space complexity
class Solution {
    public int trap(int[] height) {
        if(height.length==0) {
            return 0;
        }
        int count = 0;
        int len = height.length;
        int i=0;
        int j=len-1;
        int leftMax = height[i];
        int rightMax = height[j];
        
        while(i<=j) {
            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax, height[j]);
            if(leftMax < rightMax) {
                count += leftMax - height[i];
                i++;
            } else {
                count += rightMax - height[j];
                j--;
            }
        }
        
        return count;
    }
}





// O(n) time and O(n) space
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        left[0] = 0;
        for(int i=1; i<n; i++) {
            left[i] = Math.max(left[i-1], height[i-1]);
        }
        
        right[n-1] = 0;
        for(int i=n-2; i>=0; i--) {
            right[i] = Math.max(right[i+1], height[i+1]);
        }
        
        int res = 0;
        for(int i=0; i<n; i++) {
            int val = Math.min(left[i], right[i]) - height[i];
            if(val > 0) {
                res += val;
            }
        }
        
        return res;
    }
}
