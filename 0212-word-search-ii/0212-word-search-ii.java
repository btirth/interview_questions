class Solution {
    class Trie {
        Trie[] child;
        List<String> words;

        Trie() {
            child = new Trie[26];
            words = new ArrayList<>();
        }
    }

    List<String> ans = new ArrayList<>();
    boolean[][] visited;
    int m;
    int n;
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String word: words) {
            addWord(word, trie);
        }

        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(trie.child[board[i][j] - 'a'] != null) {
                    dfs(board, i, j, trie.child[board[i][j] - 'a']);
                }
            }
        }

        return ans;
    }

    int[][] directions = {
        {0,1},
        {1,0},
        {-1,0},
        {0,-1}
    };

    void dfs(char[][] board, int i, int j, Trie trie) {
        ans.addAll(trie.words);
        trie.words = new ArrayList<>();
        visited[i][j] = true;
        for(int[] dir: directions) {
            int x = dir[0] + i;
            int y = dir[1] + j;

            if(x>=0 && y>=0 && x<m && y<n && !visited[x][y] && trie.child[board[x][y] - 'a'] != null) {
                dfs(board, x, y, trie.child[board[x][y] - 'a']);
            }
        }
        visited[i][j] = false;
    }

    void addWord(String word, Trie trie) {
        Trie curr = trie;
        for(char ch: word.toCharArray()) {
            if(curr.child[ch - 'a'] == null) {
                curr.child[ch - 'a'] = new Trie();
            }

            curr = curr.child[ch - 'a'];
        }   

        curr.words.add(word);
    }
}