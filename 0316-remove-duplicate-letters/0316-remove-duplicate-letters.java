class Solution {
    public String removeDuplicateLetters(String s) {
        /**
        bcabc

        Stack [b, c, remove c, a]
        
        
         */
        int[] lastIndex = new int[26];
        int n = s.length();

        for(int i=0; i<n; i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> st = new Stack<>();
        int idx = 0;
        boolean[] taken = new boolean[26];
        while(idx < n) {
            if(taken[s.charAt(idx) - 'a']) {
                idx++;
                continue;
            }
            
            while(!st.isEmpty() && st.peek() > s.charAt(idx) && lastIndex[st.peek() - 'a'] > idx) {
                taken[st.pop() - 'a'] = false;
            }

            st.push(s.charAt(idx));
            taken[s.charAt(idx) - 'a'] = true;
            idx++;
        } 

        
        StringBuilder sb = new StringBuilder("");
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}