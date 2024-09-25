class Solution {
    class Trie {
        Trie[] child;
        int count;

        Trie() {
            child = new Trie[26];
            count = 0;
        }
    }

    int[] prefixCount;
    public int[] sumPrefixScores(String[] words) {
        int n = words.length;
        prefixCount = new int[n];
        Trie node = new Trie();

        for(String word: words) {
            createTrie(word, node);
        }
            
        for(int i=0; i<n; i++) {
            prefixCount[i] = countPrefix(words[i], node);
        }

        return prefixCount;
    }

    void createTrie(String word, Trie node) {
        for(char ch: word.toCharArray()) {
            if(node.child[ch-'a'] == null) {
                node.child[ch-'a'] = new Trie();
            }
            node.child[ch-'a'].count++;
            node = node.child[ch-'a'];
        }
    }

    int countPrefix(String word, Trie node) {
        int count = 0;

        for(char ch: word.toCharArray()) {
            count += node.child[ch-'a'].count;
            node = node.child[ch-'a'];
        }

        return count;
    }
}