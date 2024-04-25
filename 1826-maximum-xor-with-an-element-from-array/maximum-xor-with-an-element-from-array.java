class Solution {
    class Node {
        Node[] bits;
        
        Node() {
            bits = new Node[2];
        }
    }

    class Trie {
        Node root;

        Trie() {
            root = new Node();
        }

        void add(int num) {
            Node node = root;
            for(int i=31; i>=0; i--) {
                int bit = (num >> i) & 1;
                if(node.bits[bit] == null) {
                    node.bits[bit] = new Node();
                }

                node = node.bits[bit];
            }
        }

        int getMaxXOR(int num) {
            Node node = root;
            int val = 0;
            for(int i=31; i>=0; i--) {
                if(node == null) {
                    break;
                }
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

    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        int[][] sortedQueries = new int[n][3];
        Arrays.sort(nums);
        for(int i = 0; i<n; i++) {
            sortedQueries[i][0] = queries[i][0]; 
            sortedQueries[i][1] = queries[i][1];
            sortedQueries[i][2] = i;
        }
        Arrays.sort(sortedQueries, (a,b) -> Integer.compare(a[1], b[1]));
        Trie trie = new Trie();
        int idx = 0;
        for(int[] query: sortedQueries) {
            int x = query[0];
            int m = query[1];
            int i = query[2];
            while(idx<nums.length && nums[idx] <= m) {
                trie.add(nums[idx]);
                idx++;
            }

            int val = trie.getMaxXOR(x);
            ans[i] = idx>0 ? val : -1; 
        }    

        return ans;
    }
}