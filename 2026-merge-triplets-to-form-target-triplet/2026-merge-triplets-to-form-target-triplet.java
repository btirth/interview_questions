class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        /**
        I will pick every triplets for which a[0] < t[0] , a[1] < t[1] and a[2] < t[2]
        
         */
        
        int len = triplets.length;
        boolean foundFirst = false;
        boolean foundSecond = false;
        boolean foundThird = false; 
        
        for(int i=0; i<len; i++) {
            if(triplets[i][0] > target[0] || triplets[i][1] > target[1] || triplets[i][2] > target[2]) {
                continue;
            }

            if(triplets[i][0] == target[0]) {
                foundFirst = true;
            }

            if(triplets[i][1] == target[1]) {
                foundSecond = true;
            }

            if(triplets[i][2] == target[2]) {
                foundThird = true;
            }

            if(foundFirst && foundSecond && foundThird) {
                return true;
            }
        } 

        return false;
    }
}