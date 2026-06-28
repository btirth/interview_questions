class Solution {
    public void solve(char[][] board) {
        Queue<int[]> q = new LinkedList<>();
        int m = board.length;
        int n = board[0].length;

        for(int i=0; i<m; i++) {
            if(board[i][0] == 'O') {
                
                q.add(new int[]{i,0});
            }

            if(board[i][n-1] == 'O') {
                q.add(new int[]{i, n-1});
            }
        }

        for(int i=0; i<n; i++) {
            if(board[0][i] == 'O') {
                q.add(new int[]{0,i});
            }

            if(board[m-1][i] == 'O') {
                q.add(new int[]{m-1, i});
            }
        }

        int[][] directions = {
            {0,1},
            {1,0},
            {-1,0},
            {0,-1}
        };

        while(!q.isEmpty()) {
            int[] pt = q.poll();
            if(board[pt[0]][pt[1]] != 'O') {
                continue;
            }

            board[pt[0]][pt[1]] = '1';

            for(int[] dir: directions) {
                int x = dir[0] + pt[0];
                int y = dir[1] + pt[1];

                if(x>=0 && y>=0 && x<m && y<n && board[x][y] == 'O') {
                    q.add(new int[]{x,y});
                }
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if(board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}