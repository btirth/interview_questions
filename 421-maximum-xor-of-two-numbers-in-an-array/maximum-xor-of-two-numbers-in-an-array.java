class Solution {
    class Node {
        Node[] bits;
        
        Node() {
            bits = new Node[2];
        }
    }

    class Trie {
        Node root;
        Node node;

        Trie() {
            node = new Node();
            root = node;
        }

        void add(int num) {
            node = root;
            for(int i=31; i>=0; i--) {
                int bit = (num >> i) & 1;
                if(node.bits[bit] == null) {
                    node.bits[bit] = new Node();
                }

                node = node.bits[bit];
            }
        }

        int getMaxXOR(int num) {
            node = root;
            int val = 0;
            for(int i=31; i>=0; i--) {
                int bit = (num >> i) & 1;
                
                if(node.bits[1-bit] != null) {
                    val = val | ( 1<<i );
                    node = node.bits[1-bit];
                } else {
                    node = node.bits[bit];
                }
            }

            return val;
        }
    }
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for(int num: nums) {
            trie.add(num);
        }

        int ans = 0;
        for(int num: nums) {
            ans = Math.max(ans, trie.getMaxXOR(num));
        }

        return ans;
    }
}