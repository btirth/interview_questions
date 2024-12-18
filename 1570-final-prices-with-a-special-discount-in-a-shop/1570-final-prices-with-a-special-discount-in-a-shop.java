class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int len = prices.length;
        int[] ans = new int[len];
        
        for(int i=0; i<len; i++) {
            while(!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int idx = stack.pop();
                ans[idx] = prices[idx] - prices[i];
            }

            stack.push(i);
        }

        while(!stack.isEmpty()) {
            int idx = stack.pop();
            ans[idx] = prices[idx];
        }

        return ans;
    }
}