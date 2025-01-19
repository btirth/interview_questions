class Solution {
    public void rotate(int[][] board) {
        /**
        [1,2,3],
        [4,5,6],
        [7,8,9]
    
        [1,2]
        [3,4]
        
        temp = 1 [top][left]
        1 -> 7 [bottom][left] -> [top][left]
        7 -> 9 [bottom][right] -> [bottom][left]
        9 -> 3 [top][right] -> [bottom][right]
        3 -> temp [top][right] -> temp

        
        top, bottom, left, right

        for i in [left, right - 1]
            int temp = board[top][i]
            board[top][i] = board[n - i - 1][left]
            board[n - i - 1][left] = board[bottom][n - i - 1]
            board[bottom][n - i -1] = board[i][right]
            board[i][right] = temp

        left++
        right--
        top++
        bottom--    
        
         */

        int n = board.length;
        int left = 0;
        int right = n-1;
        int top = 0;
        int bottom = n-1;

        while(left<right && top < bottom) {
            for(int i=left; i<right; i++) {
                int temp = board[top][i];
                board[top][i] = board[n - i - 1][left];
                board[n - i - 1][left] = board[bottom][n - i - 1];
                board[bottom][n - i - 1] = board[i][right];
                board[i][right] = temp;
            } 


            left++;
            right--;
            top++;
            bottom--;
        }


    }
}