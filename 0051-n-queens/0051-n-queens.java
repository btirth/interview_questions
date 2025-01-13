class Solution {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++) {
            Arrays.fill(board[i], '.');
        }
        helper(board, 0, n);
        return ans;
    }

    void helper(char[][] board, int r, int n) {
        if(r == n) {
            
            addToAns(board, n);
            
            return;
        }

        for(int i=0; i<n; i++) {
            board[r][i] = 'Q';
            if(isValid(board, n, r, i)) {
                helper(board, r+1, n);
            }
            board[r][i] = '.';
        }
    }

    void addToAns(char[][] board, int n) {
        List<String> currBoard = new ArrayList<>();

        for(int i=0; i<n; i++) {
            currBoard.add(new String(board[i]));
        }

        ans.add(currBoard);
    }

    boolean isValid(char[][] board, int n, int r, int c) {
        for(int i=0; i<n; i++) {
            if((board[r][i] == 'Q' && i != c) || (board[i][c] == 'Q' && i != r)) {
                return false;
            }
        }

        // Diagonals


        // upper left
        for(int i=1; r-i >= 0 && c-i >= 0; i++) {
            if(board[r - i][c - i] == 'Q') {
                return false;
            }
        }


        // upper right
        for(int i=1; r-i >=0 && c+i < n; i++) {
            if(board[r - i][c + i] == 'Q') {
                return false;
            }
        }


        // lower left
        for(int i=1; r+i < n && c-i>=0; i++) {
            if(board[r + i][c - i] == 'Q') {
                return false;
            }
        }


        // lower right
        for(int i=1; r+i < n && c+i < n; i++) {
            if(board[r + i][c + i] == 'Q') {
                return false;
            }
        }

        return true;
    }
}