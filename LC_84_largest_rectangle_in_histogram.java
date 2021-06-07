/*

Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

Example 1:
  Input: heights = [2,1,5,6,2,3]
  Output: 10
  Explanation: 
    The above is a histogram where width of each bar is 1.
    The largest rectangle is shown in the red area, which has an area = 10 units.

Example 2:
  Input: heights = [2,4]
  Output: 4
 
Constraints:
  1 <= heights.length <= 10^5
  0 <= heights[i] <= 10^4

*/


// space complexity O(2n)
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if(n==1) {
            return heights[0];
        }
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = -1;
        for(int i=1; i<n; i++) {
            int p = i-1;
            while(p>=0 && heights[p]>=heights[i]) {
                p=left[p];
            }
            left[i] = p;
        }
        right[n-1] = n;
        for(int i=n-2; i>=0; i--) {
            int p = i+1;
            while(p<n && heights[p]>=heights[i]) {
                p = right[p];
            }
            right[i] = p;
        }
        
        int max = 0;
        for(int i=0; i<n; i++) {
            max = Math.max(max, (right[i]-left[i]-1)*heights[i]);
        }
        return max;
    }
}



// Space complexity O(3n)
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if(n == 1) {
            return heights[0];
        }
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> st = new Stack<Integer>();
        
        for(int i=0; i<n; i++) {
            while(!st.empty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if(st.empty()) {
                left[i] = 0;
            } else {
                left[i] = st.peek()+1;    
            }
            st.push(i);            
        }
        st = new Stack<Integer>();
        for(int i=n-1; i>=0; i--) {
            while(!st.empty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if(st.empty()) {
                right[i] = n-1;
            } else {
                right[i] = st.peek()-1;    
            }
            st.push(i);    
        }
        int max = 0;
        for(int i=0; i<n; i++) {
            max = Math.max(max, (right[i]-left[i]+1)*heights[i]);
        }
        
        return max;
    }
}
