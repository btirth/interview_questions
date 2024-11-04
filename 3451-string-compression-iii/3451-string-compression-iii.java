class Solution {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder("");
        int idx = 0;
        while(idx < word.length()) {
            int count = 0;
            char currCh = word.charAt(idx);
            while(idx < word.length() && count < 9 && word.charAt(idx) == currCh) {
                count++;
                idx++;
            }

            comp.append(count).append(currCh);
        }

        return comp.toString();
    }
}