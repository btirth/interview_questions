class Solution {
    public String removeOccurrences(String s, String part) {
        Stack<Character> st1 = new Stack<>();
        int len1 = s.length();
        int len2 = part.length();

        for(int i=0; i<len1; i++) {
            st1.push(s.charAt(i));
            if(st1.peek() == part.charAt(len2 - 1)) {
                int idx = len2 - 1;

                while(!st1.isEmpty() && idx>=0 && st1.peek() == part.charAt(idx)) {
                    st1.pop();
                    idx--;
                }

                if(idx != -1) {
                    for(int j=idx + 1; j<len2; j++) {
                        st1.push(part.charAt(j));
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder("");
        while(!st1.isEmpty()) {
            sb.append(st1.pop());
        }

        return sb.reverse().toString();
    }
}