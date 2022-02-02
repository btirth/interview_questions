/*

Given a string S consisting only of opening and closing parenthesis 'ie '('  and ')', find out the length of the longest valid(well-formed) parentheses substring.
NOTE: Length of the smallest valid substring ( ) is 2.

Example 1:
  Input: S = "(()("
  Output: 2
  Explanation: The longest valid substring is "()". Length = 2.

Example 2:
  Input: S = "()(())("
  Output: 6
  Explanation: The longest valid substring is "()(())". Length = 6.

Your Task:  
You dont need to read input or print anything. Complete the function findMaxLen() which takes S as input parameter and returns the maxlength.

Expected Time Complexity:O(n)
Expected Auxiliary Space: O(1)   

Constraints:
1 <= |S| <= 10^5

*/


class Solution {
    static int findMaxLen(String S) {
        // code here
        int res = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        char[] ch = S.toCharArray();
        
        for(int i=0; i<S.length(); i++) {
            if(ch[i] == '(') {
                st.push(i);
            } else {
                st.pop();
                
                if(st.empty()) {
                    st.push(i);
                } else {
                    res = Math.max(res, i - st.peek());
                }
            }
        }
        
        return res;
    }
}
