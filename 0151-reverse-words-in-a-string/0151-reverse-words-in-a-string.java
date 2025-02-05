class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder("");
        int idx = s.length() - 1;


        while(idx >= 0) {
            if(s.charAt(idx) == ' ') {
                idx--;
                continue;
            } 

            StringBuilder word = new StringBuilder("");

            while(idx>=0 && s.charAt(idx) != ' ') {
                word.append(s.charAt(idx));
                idx--;
            }

            word.append(" ");
            res.append(word.reverse());
        }


        if(res.length() > 0) {
            res.deleteCharAt(0);
        }

        return res.toString();
    }
}