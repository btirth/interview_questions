/*

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.

Example 1:
  Input: n = 4
  Output: 2
  Explanation: There are two distinct solutions to the 4-queens puzzle as shown.

Example 2:
  Input: n = 1
  Output: 1

Constraints:
  1 <= n <= 9

*/


class Solution {
    Set<String> solutions = new HashSet<>();
    public int totalNQueens(int n) {
        solveNQueens(n, 0, new boolean[n][n]);
        return solutions.size();
    }
    
    void solveNQueens(int n, int r, boolean[][] board) {
        if(r == n) {
            solutions.add(getSolution(board));
            return;
        }
        
        if(r > n) {
            return;
        }
        
        for(int i=0; i<n; i++) {
            if(checkPossible(board, r, i)) {
                board[r][i] = true;
                solveNQueens(n, r+1, board);
                board[r][i] = false;
            }
        }
    }
    
    boolean checkPossible(boolean[][] board, int row, int col) {
        int n = board.length;
        
        for(int i=0; i<n; i++) {
            if(board[row][i] || board[i][col]) {
                return false;
            }
            
            if(row+i < n) {
                if(col+i < n && board[row+i][col+i]) {
                    return false;
                } 
                
                if(col-i >= 0 && board[row+i][col-i]) {
                    return false;
                } 
            } 
            
            if(row-i >= 0) {
                 if(col+i < n && board[row-i][col+i]) {
                    return false;
                } 
                
                if(col-i >= 0 && board[row-i][col-i]) {
                    return false;
                } 
            }
        }
        
        return true;
    }
    
    String getSolution(boolean[][] board) {
        int n = board.length;
        String sol = "";
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j]) {
                    sol += ',';
                } else {
                    sol += '.';
                }
            }
        }
        
        return sol;
    }
}
