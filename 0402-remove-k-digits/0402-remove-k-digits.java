class Solution {
    public String removeKdigits(String num, int k) {
        /**
        41432219

        Stack = [4] k = 3
        [1], 2
        [1,4],2
        [1,3] 1
        [1,2] 0
        [1,2,2,1,9]
    
         */

        Stack<Character> stack = new Stack<>();
        int idx = 0;
        int n = num.length();

        while(idx<n) {
            while(!stack.isEmpty() && stack.peek() > num.charAt(idx) && k>0) {
                stack.pop();
                k--;
            }

            stack.push(num.charAt(idx));
            idx++;
        } 

        while(!stack.isEmpty() && k>0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder("");
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        sb = sb.reverse();
        int actualStartIdx = 0;
        while(actualStartIdx < sb.length() && sb.charAt(actualStartIdx) == '0') {
            actualStartIdx++;
        }

        if(actualStartIdx == sb.length()) {
            return "0";
        }

        return sb.toString().substring(actualStartIdx);
    }
}