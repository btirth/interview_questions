/*

Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. 
The same letter cell may not be used more than once.

Example 1:
  Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
  Output: true

Example 2:
  Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
  Output: true

Example 3:
  Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
  Output: false

Constraints:
  m == board.length
  n = board[i].length
  1 <= m, n <= 6
  1 <= word.length <= 15
  board and word consists of only lowercase and uppercase English letters.
 
Follow up: Could you use search pruning to make your solution faster with a larger board?

*/


class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(helper(board, word, i, j, 1, visited)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    boolean helper(char[][] board, String word, int i, int j, int idx, boolean[][] visited) {
        if(idx == word.length()) {
            return true;
        }
        
        if(i>=board.length || j>=board[0].length || i<0 || j<0 || visited[i][j]) {
            return false;
        }
        
        visited[i][j] = true;
        
        if(i>0 && !visited[i-1][j] && board[i-1][j] == word.charAt(idx) && helper(board, word, i-1, j, idx+1, visited)) {
            return true;
        }
        
        if(i<=board.length-2 && !visited[i+1][j] && board[i+1][j] == word.charAt(idx) && helper(board, word, i+1, j, idx+1, visited)) {
            return true;
        }
        
        if(j>0 && !visited[i][j-1] && board[i][j-1] == word.charAt(idx) && helper(board, word, i, j-1, idx+1, visited)) {
            return true;
        }
        
        if(j<=board[0].length-2 && !visited[i][j+1] && board[i][j+1] == word.charAt(idx) && helper(board, word, i, j+1, idx+1, visited)) {
            return true;
        }
        
        visited[i][j] = false;
        return false;
    }
}
