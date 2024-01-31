class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        for(int i=0; i<n; i++) {
            while(!stack.isEmpty() && temp[stack.peek()] < temp[i]) {
                int prevDay = stack.pop();
                ans[prevDay] = i - prevDay;
            }

            stack.push(i);
        }

        return ans;
    }
}