/*

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

Example 1:
    Input: n = 4
    Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
    Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

Example 2:
    Input: n = 1
    Output: [["Q"]]
 
Constraints:
    1 <= n <= 9

*/

class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        helper(board, 0, ans);
        
        return ans;
    }
    
    void helper(boolean[][] board, int row, List<List<String>> ans) {
        
        if(row >= board.length) {
            addAns(board, ans);
            return;
        }
        
        for(int i=0; i<board.length; i++) {
            if(isPossible(board, row, i)) {
                board[row][i] = true;
                helper(board, row+1, ans);
                board[row][i] = false;
            }
        }
    }
    
    boolean isPossible(boolean[][] board, int row, int col) {
        int n = board.length;
        
        // check row and column
        for(int i=0; i<n; i++) {
            if(board[i][col] || board[row][i]) {
                return false;
            }
        }
        
        // check upper right diagonal
        for(int i = row, j = col; i>=0 && j<n; i--, j++) {
            if(board[i][j]) {
                return false;
            }
        }
        
        // check upper left diagonal
        for(int i = row, j = col; i>=0 && j>=0; i--, j--) {
            if(board[i][j]) {
                return false;
            }
        }

        return true;
    }
    
    void addAns(boolean[][] board, List<List<String>> ans) {
        List<String> curr = new ArrayList<>();
        
        for(int i=0; i<board.length; i++) {
            String row = "";
            for(int j=0; j<board.length; j++) {
                if(board[i][j]) {
                    row += "Q";
                } else {
                    row += ".";
                }
            }
            
            curr.add(row);
        }
        
        ans.add(curr);
    }
}
