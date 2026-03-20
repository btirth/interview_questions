class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> stack = new Stack<>();
        int n = temp.length;
        int[] res = new int[n];

        for(int i=0; i<n; i++) {
            while(!stack.isEmpty() && temp[stack.peek()] < temp[i]) {
                int prev = stack.pop();
                res[prev] = i - prev;
            }

            stack.push(i);
        }

        return res;
    }
}