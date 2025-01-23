class Solution {
    public int myAtoi(String s) {
        boolean isNeg = false;
        boolean firstChar = false;
        long val = 0;
        for(char ch: s.toCharArray()) {
            if(ch == '+' && !firstChar) {
               
            } else if(ch == '-' && !firstChar) {
                isNeg = true;
            } else if(!firstChar && ch == ' ' && val == 0) {
                continue;
            } else if(ch >= '0' && ch <= '9') {
                val = (val*10) + (ch - '0');
            } else {
                break;
            }

            firstChar = true;

            if(!isNeg && val >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if(isNeg && -1*val <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }

        return isNeg ? -1*(int)val : (int)val;
    }
}