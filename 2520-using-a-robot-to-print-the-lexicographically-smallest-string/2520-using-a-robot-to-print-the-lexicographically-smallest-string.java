class Solution {
    public String robotWithString(String s) {
        /**
        first thing find smalles character

        then there are 2 ways:
        -> Is any smaller but greater element present on the right
            -> If yes, move towards right, and find that
        -> Start printing until you've stack top such that it's bigger than smallest element on right and then again keep printing    
        
         */
    
        Stack<Character> st = new Stack<>();
        int len = s.length();
        char[] smallestOnRight = new char[len];
        StringBuilder result = new StringBuilder("");

        char smallest = s.charAt(len - 1);
        
        for(int i=len - 1; i>=0; i--) {
            if(smallest > s.charAt(i)) {
                smallest = s.charAt(i);
            }

            smallestOnRight[i] = smallest;
        }

        for(int i=0; i<len; i++) {
            while(!st.isEmpty() && st.peek() <= smallestOnRight[i]) {
                result.append(st.pop());
            }

            st.push(s.charAt(i));
        }

        while(!st.isEmpty()) {
            result.append(st.pop());
        }

        return result.toString();
    }
}