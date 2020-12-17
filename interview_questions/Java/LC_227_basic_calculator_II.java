/*

Given a string s which represents an expression, evaluate this expression and return its value. 

The integer division should truncate toward zero.

 
Example 1:
    Input: s = "3+2*2"
    Output: 7

Example 2:
    Input: s = " 3/2 "
    Output: 1

Example 3:
    Input: s = " 3+5 / 2 "
    Output: 5
 

Constraints:
    1 <= s.length <= 3 * 105
    s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
    s represents a valid expression.
    All the integers in the expression are non-negative integers in the range [0, 231 - 1].
    The answer is guaranteed to fit in a 32-bit integer.

*/


class Solution {
    public int calculate(String s) {
        s.trim();
        if(s==null || s.length()==0) {
            return 0;
        }
        
        Stack<Integer> st = new Stack<Integer>();
        int i = 0;
        char lastOp = '+';
        
        while(i < s.length()) {
            char c = s.charAt(i);
            if(c==' ') {
                i++;
                continue;
            } else if(Character.isDigit(c)) {
                int temp = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))) {
                    temp = temp*10 + (s.charAt(i)-'0');
                    i++;
                }
                
                if(lastOp == '+') {
                    st.push(temp);
                } else if(lastOp == '-') {
                    st.push(-temp);
                } else if(lastOp == '*') {
                    st.push(st.pop()*temp);
                } else if(lastOp == '/') {
                    st.push(st.pop() / temp);
                }
                
            } else {
                lastOp = c;
                i++;
            }
        }
        int ans = 0;
        for(int a :st) {
            ans += a;
        }
        return ans;
    }
}