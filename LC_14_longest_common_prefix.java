/*

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:
  Input: strs = ["flower","flow","flight"]
  Output: "fl"

Example 2:
  Input: strs = ["dog","racecar","car"]
  Output: ""
  Explanation: There is no common prefix among the input strings.
 
Constraints:
  1 <= strs.length <= 200
  0 <= strs[i].length <= 200
  strs[i] consists of only lower-case English letters.

*/


// Using Trie
class Solution {
    class TrieNode {
        char val;
        int wc;
        TrieNode[] child;
        
        TrieNode(char val) {
            this.val = val;
            wc = 1;
            child = new TrieNode[26];
        }
    }
    int right = Integer.MAX_VALUE;
    public void  constructTrie(String s, TrieNode root, int i) {
        TrieNode r = root;
        for(int j=0; j<s.length(); j++) {
            int idx = s.charAt(j)-'a';
            if(r.child[idx] == null) {
                if(i==0) {
                    r.child[idx] = new TrieNode(s.charAt(j));    
                } else {
                    right = Math.min(right, j);
                    break;    
                } 
            } 
            r = r.child[idx];
        }
    }
    
    public String longestCommonPrefix(String[] strs) {
        TrieNode root = new TrieNode('1');
        int n = strs.length;
        
        String minS = strs[0];
        for(int i=0; i<n; i++) {
            minS = strs[i].length() < minS.length() ? strs[i] : minS;
            constructTrie(strs[i], root, i);
        }
        return right<minS.length() ? strs[0].substring(0,right) : minS;
    }
}



// Method 2
class Solution {
    public String longestCommonPrefix(String[] strs) {
       StringBuilder sb =  new StringBuilder();
        int index = 0;
        while(index < strs[0].length()) {
            char c = strs[0].charAt(index);
            for (String s : strs) {
                if (s.length() == index) return sb.toString();
                if (s.charAt(index) != c) return sb.toString();
            }
            sb.append(c);
            index++;
        }
        return sb.toString();
    }
}
