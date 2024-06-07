class Solution {
    class Trie {
        Trie[] child;
        Trie() {
            child = new Trie[27];
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        createTrie(dictionary, trie);

        StringBuilder sb = new StringBuilder("");
        String[] words = sentence.split(" ");
        for(String word: words) {
            StringBuilder newWord = new StringBuilder("");
            Trie temp = trie;
            for(char ch: word.toCharArray()) {
                if(temp.child[ch-'a'] == null) {
                    newWord = new StringBuilder(word);
                    break;
                }

                temp = temp.child[ch-'a'];
                newWord.append(""+ch);
                if(temp.child[26] != null) {
                    break;
                }
            }

            sb.append(newWord).append(" ");
        }

        return new String(sb).trim();
    }

    void createTrie(List<String> dictionary, Trie trie) {
        for(String word: dictionary) {
            Trie temp = trie;
            for(char ch: word.toCharArray()) {
                if(temp.child[ch-'a'] == null) {
                    temp.child[ch-'a'] = new Trie();
                }

                temp = temp.child[ch-'a'];
            }

            temp.child[26] = new Trie(); 
        }
    }
}