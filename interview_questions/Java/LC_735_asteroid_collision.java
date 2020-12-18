class Solution {
    public int[] asteroidCollision(int[] ast) {
       
        Stack<Integer> st = new Stack<Integer>();
        st.push(ast[0]);
       
        for(int i=1; i<ast.length; i++) {
            boolean alive = true;
            while(!st.empty() && st.peek() > 0 && ast[i] < 0) {
                if(Math.abs(st.peek()) < Math.abs(ast[i])) {
                    st.pop();
                } else if(Math.abs(st.peek()) > Math.abs(ast[i])) {
                    alive = false;
                    break;
                } else  {
                    alive = false;
                    st.pop();
                    break;
                }
            }
            if(alive) {
                st.push(ast[i]);
            }  
        }
        
        int[] ans = new int[st.size()];
        int j = 0;
        for(int n : st) {
            ans[j] = n;
            j++;
        }
        return ans;
    }
}