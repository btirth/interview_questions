class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) {
            return false;
        }

        for(int i=0; i<goal.length(); i++) {
            if((s.startsWith(goal.substring(0, i+1)) && s.endsWith(goal.substring(i+1))) ||
                (s.endsWith(goal.substring(0, i+1)) && s.startsWith(goal.substring(i+1)))
            ) {
                return true;
            }
        }

        return false;
    }
}