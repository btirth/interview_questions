class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        Set<String> operators = Set.of("*", "/", "+", "-");

        for(String token: tokens) {
            if(operators.contains(token)) {
                int prev1 = Integer.valueOf(stack.pop());
                int prev2 = Integer.valueOf(stack.pop());

                if(token.equals("*")) {
                    stack.push(String.valueOf(prev1 * prev2));
                } else if(token.equals("+")) {
                    stack.push(String.valueOf(prev1 + prev2));
                } else if(token.equals("/")) {
                    stack.push(String.valueOf(prev2 / prev1));
                } else {
                    stack.push(String.valueOf(prev2 - prev1));
                }
            } else {
                stack.push(token);
            }
        }

        return Integer.valueOf(stack.peek());
    }
}