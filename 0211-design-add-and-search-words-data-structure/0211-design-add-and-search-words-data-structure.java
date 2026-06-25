class WordDictionary {
    class Node {
        Node[] next;
        boolean end;

        public Node() {
            this.next = new Node[26];
        }
    }

    Node trie;
    public WordDictionary() {
        trie = new Node();
    }
    
    public void addWord(String word) {
        Node temp = trie;

        for(char ch: word.toCharArray()) {
            if(temp.next[ch - 'a'] == null) {
                temp.next[ch - 'a'] = new Node();
            }

            temp = temp.next[ch - 'a'];
        }

        temp.end = true;
    }
    
    public boolean search(String word) {
        Node temp = trie;
        return check(word, 0, temp);
    }

    boolean check(String word, int idx, Node node) {

        if(idx == word.length()) {
            return node.end;
        }

        char ch = word.charAt(idx);
        if(ch == '.') {
            for(int i=0; i<26; i++) {
                if(node.next[i] != null && check(word, idx + 1, node.next[i])) {
                    return true;
                }
            }

            return false;
        } else if(node.next[ch - 'a'] == null) {
            return false;
        } 

        return check(word, idx + 1, node.next[ch - 'a']);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */