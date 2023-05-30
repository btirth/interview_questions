class Solution {
    class Trie {
        Trie[] ch = new Trie[26];
        List<String> words = new ArrayList<>();
    }

    Trie getPrefixTrie(String[] words) {
        Trie node = new Trie();
        for(String word: words) {
            addWord(node, word);
        }

        return node;
    }

    void addWord(Trie node, String word) {
        for(int i=0; i<word.length(); i++) {
            if(node.ch[word.charAt(i)-'a'] == null)
                node.ch[word.charAt(i)-'a'] = new Trie();
            node = node.ch[word.charAt(i)-'a'];
        }

        node.words.add(word);
    }

    int[][] directions = {
        {0,1},
        {1,0},
        {-1,0},
        {0,-1}
    };

    void helper(char[][] board, int i, int j, Trie node, boolean[][] visited) {
        visited[i][j] = true;
        ans.addAll(node.words);
        node.words = new ArrayList<>();
        for(int[] dir: directions) {
            int x = i + dir[0];
            int y = j + dir[1];

            if(x>=0 && y>=0 && x<board.length && y<board[0].length && !visited[x][y] && node.ch[board[x][y]-'a'] != null) {
                helper(board, x, y, node.ch[board[x][y]-'a'], visited);
            } 
        }

        visited[i][j] = false;
    }

    List<String> ans = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        Trie node = getPrefixTrie(words);
        int m = board.length;
        int n = board[0].length;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(node.ch[board[i][j]-'a'] != null) {
                    helper(board, i, j, node.ch[board[i][j]-'a'], new boolean[m][n]);
                }
            }
        }

        return ans;
    }
}