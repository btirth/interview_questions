class Solution {
    int m;
    int n;
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(backtrack(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        
        return false;
    }

    int[][] directions = {
        {0,1},
        {1,0},
        {-1,0},
        {0,-1}
    };

    boolean backtrack(char[][] board, String word, int idx, int r, int c) {
        if(word.charAt(idx) != board[r][c]) {
            return false;
        }

        if(idx == word.length() - 1) {
            return true;
        }

        visited[r][c] = true;
        for(int[] dir: directions) {
            int x = dir[0] + r;
            int y = dir[1] + c;

            if(x>=0 && y>=0 && x < m && y < n && !visited[x][y]) {
                if(backtrack(board, word, idx + 1, x, y)) {
                    return true;
                }
            }
        }

        visited[r][c] = false;

        return false;
    }
}