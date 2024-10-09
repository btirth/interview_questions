class Solution {
    public int minAddToMakeValid(String s) {
        int minNeeds = 0;
        int open = 0;

        for(char ch: s.toCharArray()) {
            if(ch == '(') {
                open++;
            } else {
                open--;
            }

            if(open < 0) {
                minNeeds += Math.abs(open);
                open = 0;
            }
        }

        return minNeeds + Math.abs(open);
    }
}