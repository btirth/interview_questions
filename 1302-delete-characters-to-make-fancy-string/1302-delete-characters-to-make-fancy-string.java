class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder("");
        int count = 0;
        char prev = '-';

        for(char ch: s.toCharArray()) {
            if(ch == prev) {
                count++;
            } else {
                count = 1;
                prev = ch;
            }

            if(count < 3) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}