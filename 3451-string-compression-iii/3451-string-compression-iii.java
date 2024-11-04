class Solution {
    public String compressedString(String word) {
        char[] ch = word.toCharArray();
        StringBuilder comp = new StringBuilder("");
        int idx = 0;
        while(idx < word.length()) {
            int count = 0;
            char currCh = ch[idx];
            while(idx < word.length() && count < 9 && ch[idx] == currCh) {
                count++;
                idx++;
            }

            comp.append(""+count);
            comp.append(""+currCh);
        }

        return comp.toString();
    }
}