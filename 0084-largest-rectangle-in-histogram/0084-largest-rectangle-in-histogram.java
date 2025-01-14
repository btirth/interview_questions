class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int idx = 0;
        Stack<Integer> stack = new Stack<>();

        while(idx < n) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[idx]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                left[idx] = -1;
            } else {
                left[idx] = stack.peek();
            }

            stack.push(idx);
            idx++;
        }

        stack = new Stack<>();
        idx = n-1;

        while(idx >= 0) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[idx]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                right[idx] = n;
            } else {
                right[idx] = stack.peek();
            }

            stack.push(idx);
            idx--;
        }

        int ans = 0;
        for(int i=0; i<n; i++) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }

        return ans;
    }
}