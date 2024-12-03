class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder("");
        int prevIdx = 0;
        for(int space: spaces) {
            sb.append(s.substring(prevIdx, space)).append(" ");
            prevIdx = space;
        }

        sb.append(s.substring(prevIdx));
        return sb.toString();
    }
}