/*

A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings.
There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.

Example 1:
  Input
    ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
    [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
  Output
    [null, null, true, false, true, null, true]
  Explanation
    Trie trie = new Trie();
    trie.insert("apple");
    trie.search("apple");   // return True
    trie.search("app");     // return False
    trie.startsWith("app"); // return True
    trie.insert("app");
    trie.search("app");     // return True


Constraints:
  1 <= word.length, prefix.length <= 2000
  word and prefix consist only of lowercase English letters.
  At most 3 * 10^4 calls in total will be made to insert, search, and startsWith.

*/

class Trie {
    class Node {
        // index 0-25 is for letters and 26th index is for word ending.
        Node[] child = new Node[27];
    }

    Node start;
    public Trie() {
        start = new Node();
    }
    
    public void insert(String word) {
        Node temp = start;
        for(char ch: word.toCharArray()) {
            if(temp.child[ch-'a'] == null) {
                temp.child[ch-'a'] = new Node();
            }

            temp = temp.child[ch-'a'];
        }
        temp.child[26] = new Node();
    }
    
    public boolean search(String word) {
        Node temp = start;
        for(char ch: word.toCharArray()) {
            if(temp.child[ch-'a'] == null) {
                return false;
            }

            temp = temp.child[ch-'a'];
        }

        if(temp.child[26] == null) {
            return false;
        }
        return true;
    }
    
    public boolean startsWith(String prefix) {
        Node temp = start;
        for(char ch: prefix.toCharArray()) {
            if(temp.child[ch-'a'] == null) {
                return false;
            }

            temp = temp.child[ch-'a'];
        }
        
        return true;
    }
}
