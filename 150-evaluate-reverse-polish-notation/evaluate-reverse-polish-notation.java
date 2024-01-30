class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String t: tokens) {
            if(t.equals("*")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.add(a*b);
            } else if(t.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                if(a==0 || b == 0) {
                    stack.add(0);
                    continue;
                }
                stack.add(b/a);
            } else if(t.equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.add(a+b);
            } else if(t.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.add(b-a);
            } else {
                stack.push(Integer.parseInt(t));
            }
        }

        return stack.pop();
    }
}