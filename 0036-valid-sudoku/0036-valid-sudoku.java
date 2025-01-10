class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] != '.' && !isValid(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    boolean isValid(char[][] board, int r, int c) {
        if(!validRow(board, r, c) || !validColumn(board, r, c) || !validSubBox(board, r, c)) {
            return false;
        }

        return true;
    }

    boolean validRow(char[][] board, int r, int c) {
        char target = board[r][c];

        for(int i=0; i<c; i++) {
            if(i != c && board[r][i] == target) {
                return false;
            }
        }

        return true;
    }

    boolean validColumn(char[][] board, int r, int c) {
        char target = board[r][c];

        for(int i=0; i<r; i++) {
            if(i != r && board[i][c] == target) {
                return false;
            }
        }

        return true;
    }

    boolean validSubBox(char[][] board, int r, int c) {
        char target = board[r][c];
        int rowOffset = r % 3;
        int columnOffset = c % 3;

        /**
        r = 2, c = 4

        colOff = 4%3 = 1
        rowOff = 2%3 = 2
        
        4-1 = 3 -> 4 + 3 - 1 = 6 [3,4,5]
        col - colOff -> col + 3 - offset

        2-2 = 0 -> 2 + 3 - 2 = 3 [0, 1, 2]
        row - rowOff -> row + 3 - offset
         */

         for(int i = r - rowOffset; i < r + 3 - rowOffset; i++) {
            for(int j = c - columnOffset; j < c + 3 - columnOffset; j++) {
                if(i == r && j == c) {
                    continue;
                }

                if(board[i][j] == target) {
                    return false;
                }
            }
         }

         return true;
    }
}