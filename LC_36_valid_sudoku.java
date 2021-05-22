/*

Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

Note:
  A Sudoku board (partially filled) could be valid but is not necessarily solvable.
  Only the filled cells need to be validated according to the mentioned rules.
 
Example 1:
  Input: board = 
    [["5","3",".",".","7",".",".",".","."]
    ,["6",".",".","1","9","5",".",".","."]
    ,[".","9","8",".",".",".",".","6","."]
    ,["8",".",".",".","6",".",".",".","3"]
    ,["4",".",".","8",".","3",".",".","1"]
    ,["7",".",".",".","2",".",".",".","6"]
    ,[".","6",".",".",".",".","2","8","."]
    ,[".",".",".","4","1","9",".",".","5"]
    ,[".",".",".",".","8",".",".","7","9"]]
  Output: true

Example 2:
  Input: board = 
    [["8","3",".",".","7",".",".",".","."]
    ,["6",".",".","1","9","5",".",".","."]
    ,[".","9","8",".",".",".",".","6","."]
    ,["8",".",".",".","6",".",".",".","3"]
    ,["4",".",".","8",".","3",".",".","1"]
    ,["7",".",".",".","2",".",".",".","6"]
    ,[".","6",".",".",".",".","2","8","."]
    ,[".",".",".","4","1","9",".",".","5"]
    ,[".",".",".",".","8",".",".","7","9"]]
  Output: false
  Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 

Constraints:
  board.length == 9
  board[i].length == 9
  board[i][j] is a digit or '.'.

*/



class Solution {
    public boolean isPossible(char[][] board, int row, int col) {
        int n = board[row][col];
        for(int i=0; i<9; i++) {
            if((board[row][i]==n && i!=col) || (board[i][col]==n && i!=row)) {
                return false;
            }
        }
        int boxR = (row / 3) * 3;
        int boxC = (col / 3) * 3;
        for(int i=0; i<=2; i++) {
            for(int j=0; j<=2; j++) {
                if(board[i+boxR][j+boxC]==n && ((i+boxR)!=row && (j+boxC)!=col)) {   
                    return false;
                }
            }
        }
        return true;
    }
    
    boolean isValidSudoku(char[][] board, int row, int col) {
        if(row >= 9) {
            return true;
        }
        int nextRow = row;
        int nextCol = col+1;
        if(nextCol >= 9) {
            nextRow = row+1;
            nextCol = 0;
        }
        if(board[row][col] != '.') {
            if (!isPossible(board, row, col)) {
                return false;
            }
        }
        
        if(!isValidSudoku(board, nextRow, nextCol)) {
            return false;
        }    
        return true;
    }
    
    public boolean isValidSudoku(char[][] board) {
        return isValidSudoku(board, 0, 0);
    }
}
