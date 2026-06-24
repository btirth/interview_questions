class Trie {
    class Node {
        Node[] next;
        boolean isEnd;

        public Node() {
            this.next = new Node[26];
        }
    }

    Node node;
    public Trie() {
        node = new Node();
    }
    
    public void insert(String word) {
        Node temp = node;

        for(char ch: word.toCharArray()) {
            if(temp.next[ch - 'a'] == null) {
                temp.next[ch - 'a'] = new Node();
            }

            temp = temp.next[ch - 'a'];
        }

        temp.isEnd = true;
    }
    
    public boolean search(String word) {
        Node temp = check(word);
        if(temp == null) {
            return false;
        }

        return temp.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Node temp = check(prefix);
        if(temp == null) {
            return false;
        }

        return true;
    }

    public Node check(String word) {        
        Node temp = node;

        for(char ch: word.toCharArray()) {
            if(temp.next[ch - 'a'] == null) {
                return null;
            }

            temp = temp.next[ch - 'a'];
        }

        return temp;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */