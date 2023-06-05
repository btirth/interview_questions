class Solution {
    public boolean checkStraightLine(int[][] coord) {
        int deltaX = coord[0][0] - coord[1][0];
        int deltaY = coord[0][1] - coord[1][1];

        for(int i=2; i<coord.length; i++) {
            if((deltaX*(coord[i][1]-coord[i-1][1])) != (deltaY*(coord[i][0]-coord[i-1][0]))) {
                return false;
            }
        }

        return true;
    }
}