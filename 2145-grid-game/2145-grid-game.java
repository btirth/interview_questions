class Solution {
    public long gridGame(int[][] grid) {
        /**
        robot1 will definitely take 0,0 and 1,n-1 so it's better to make them 0.

        then robot1 can 
        -> Take whole 0th row -> ans = 1st row sum
        -> take whole 1st row -> ans = 2nd row sum
        -> Some last element from 1st row and remaining 0th row
            -> If we have idx = x from where robot1 changed the row
            -> ans = Math(sum((0,x+1) -> (0,n-1)), sum(1,0) -> (1, x-1)); 

        0 5 4
        1 5 0

        9 9 4
        6 5 0


         */

        int n = grid[0].length;
        long[][] newGrid = new long[2][n];
        for(int i=0; i<n; i++) {
            newGrid[0][i] = grid[0][i];
            newGrid[1][i] = grid[1][i];
        }

        newGrid[0][0] = 0;
        newGrid[1][n-1] = 0;

        for(int i=n-2; i>=0; i--) {
            newGrid[0][i] += newGrid[0][i+1];
            newGrid[1][i] += newGrid[1][i+1];
        }

        long ans = newGrid[1][0];

        for(int i=0; i<n-1; i++) {
            ans = Math.min(ans, Math.max(newGrid[0][i+1], i>0 ? (newGrid[1][0] - newGrid[1][i]) : 0));
        }

        return ans;
    }
}