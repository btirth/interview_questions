class Solution {
    public int minOperations(String s) {
        char next = '0';

        int count0 = 0;
        int count1 = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) != next) {
                count0++;
            } 

            next = next == '0' ? '1' : '0';
        }

        next = '1';

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) != next) {
                count1++;
            } 

            next = next == '0' ? '1' : '0';
        }

        return Math.min(count0, count1);
    }
}