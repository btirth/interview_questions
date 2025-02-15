class Solution {
    public int punishmentNumber(int n) {
        /**
        The decimal representation of i * i can be partitioned into 
        contiguous substrings such that the sum of the integer values of these substrings equals i.

        
        
         */


        int count = 0;

        for(int i=1; i<=n; i++) {
            int sq = i * i;

            if(isValid(i, "" + sq, 0)) {
                count += sq;
            }
        } 

        return count;
    }

    boolean isValid(int i, String square, int idx) {
        if(idx == square.length()) {
            if(i == 0) {
                return true;
            }

            return false;
        }

        if(i < 0) {
            return false;
        }

        for(int j=idx + 1; j<=square.length(); j++) {
            if(isValid(i - Integer.valueOf(square.substring(idx, j)), square, j)) {
                return true;
            }
        }

        return false;
    }


}