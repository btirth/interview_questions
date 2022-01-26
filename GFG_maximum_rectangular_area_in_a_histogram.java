/*

Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a number of contiguous bars. For simplicity, assume that all bars have the same width and the width is 1 unit, there will be N bars height of each bar will be given by the array arr.

Example 1:
  Input:
  N = 7
  arr[] = {6,2,5,4,5,1,6}
  Output: 12

Example 2:
  Input:
    N = 8
    arr[] = {7 2 8 9 1 3 6 5}
  Output: 16
  Explanation: Maximum size of the histogram will be 8  and there will be 2 consecutive histogram. And hence the area of the histogram will be 8x2 = 16.

Your Task:
The task is to complete the function getMaxArea() which takes the array arr[] and its size N as inputs and finds the largest rectangular area possible and returns the answer.

Expected Time Complxity : O(N)
Expected Auxilliary Space : O(N)

Constraints:
1 ≤ N ≤ 10^6
1 ≤ arr[i] ≤ 10^12

*/


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) 
    {
        // your code here
        Stack<Integer> st = new Stack<>();
        int[] left = new int[(int)n];
        int[] right = new int[(int)n];
        
        long ans = 0;
        
        left[0] = -1;
        st.push(0);
        for(int i=1; i<n; i++) {
            
            while(!st.isEmpty() && hist[st.peek()] >= hist[i]) {
                st.pop();
            }
            
            if(st.empty()) {
                left[i] = -1;
            } else {
                left[i] = st.peek();
            }
            
            st.push(i);
        }
        
        st = new Stack<>();
        int newN = right.length;
        right[newN-1] = newN;
        st.push(newN-1);
        
        for(int i=newN-2; i>=0; i--) {
            while(!st.empty() && hist[st.peek()] >= hist[i]) {
                st.pop();
            }
            
            if(st.empty()) {
                right[i] = newN;
            } else {
                right[i] = st.peek();
            }
            
            st.push(i);
        }
             
        for(int i=0; i<n; i++) {
            ans = Math.max(ans, (right[i]-left[i]-1)*hist[i]);
        }
        
        return ans;
    }
        
}
