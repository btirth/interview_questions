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
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        int[] count = new int[len];
        
        int maxH = 0;
        for(int i=0; i<len; i++) {
            leftMax[i] = maxH;
            if(height[i] > maxH) {
                maxH = height[i];
            }
        }
        
        maxH = 0;
        for(int i=len-1; i>=0; i--) {
            rightMax[i] = maxH;
            if(height[i] > maxH) {
                maxH = height[i];
            }
        }
        
        for(int i=0; i<len; i++) {
            int water = Math.min(leftMax[i], rightMax[i]) - height[i];
            if(water>0) {
                count[i] = water;
            }
        }
        
        int ans = 0;
        for(int i=0; i<len; i++) {
            ans += count[i];
        }
        
        return ans;
    }
}
