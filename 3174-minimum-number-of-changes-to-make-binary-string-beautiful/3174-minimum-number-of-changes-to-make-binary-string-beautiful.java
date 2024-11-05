class Solution {
    public int minChanges(String s) {
        int changes = 0;
        char prev = '2';
        for(int i=0; i<s.length(); i++) {
            if(prev == '2') {
                prev = s.charAt(i);
                continue;
            } else if(prev != s.charAt(i)) {
                changes++;
            }
            prev = '2';
        }

        return changes;
    }
}