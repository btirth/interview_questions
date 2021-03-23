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
        boolean isPossible(int[][] board, int n, int row, int column) {
        // same column
        for(int i=row-1; i>=0; i--) {
            if(board[i][column] == 1) {
                return false;
            }
        }
        
        // Upper Left Diagonal
        for(int i=row-1, j=column-1; i>=0 && j>=0; i--, j--) {
            if(board[i][j] == 1) {
                return false;
            }
        }
        
        // Upper Right Diagonal
        for(int i=row-1, j=column+1; i>=0 && j<n; i--, j++) {
            if(board[i][j] == 1) {
                return false;
            }
        }
        
        
        return true;
    }
    void nQueensHelper(int n, int row, int[][] board, List<List<String>> res) {
        if(row == n) {
            // we have find the solution print the matrix
            List<String> curr = new ArrayList<String>();
            for(int i=0; i<n; i++) {
                StringBuilder str = new StringBuilder();
                for(int j=0; j<n; j++) {
                    if(board[i][j] == 1) {
                        str.append('Q');
                    } else {
                        str.append('.');
                    }
                }
                curr.add(new String(str));
            }
            res.add(curr);
        }
        
        //Place at all possible postion and go for next row
        for(int i=0; i<n; i++) {
            if(isPossible(board, n, row, i)) {
                board[row][i] = 1;
                nQueensHelper(n, row+1, board, res);
                board[row][i] = 0;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        List<List<String>> res = new ArrayList<>();
        nQueensHelper(n, 0, board, res);
        return res;
    }
}