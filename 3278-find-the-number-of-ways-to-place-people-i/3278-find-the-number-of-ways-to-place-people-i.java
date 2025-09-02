class Solution {
    public int numberOfPairs(int[][] points) {
        /**
        
        for A to be on the upper-left side of B
        A[0] <= B[0] & A[1] >= B[1] & !(A[0] == B[0] && A[1] == B[1]) same same but different

        Too check no other points in the way
        -> We can check every other point

        TC
        -> O(n ^ 3)
        
         */

        int count = 0;
        int n = points.length;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                // j is upper left point, and i is reference point for j
                if(i != j && points[j][0] <= points[i][0] && points[j][1] >= points[i][1] && check(points, i, j)) {
                    count++;
                }
            }
        } 

        return count;
    }

    boolean check(int[][] points, int i, int j) {
        /**
        For any points to be between points i and j

        k[0] >= j[0] && k[0] <= i[0] && k[1] <= j[1] && k[1] >= i[1]
        
         */
        int n = points.length;
        
        for(int k=0; k<n; k++) {
            if(k != i && k != j && points[k][0] >= points[j][0] && points[k][0] <= points[i][0] &&
                points[k][1] <= points[j][1] && points[k][1] >= points[i][1]
            ) {
                return false;
            }
        }

        return true;
    }
}