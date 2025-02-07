class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder("");
        int count = 0;

        for(char ch: s.toCharArray()) {
            if(ch == '(') {
                if(count >= 1) {
                    sb.append("(");
                }
                count++;
            } else {
                if(count > 1) {
                    sb.append(")");
                }

                count--;
            }
        }

        return sb.toString();
    }
}