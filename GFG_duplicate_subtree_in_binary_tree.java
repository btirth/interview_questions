/*

Given a binary tree, find out whether it contains a duplicate sub-tree of size two or more, or not.

Example 1 :
  Input : 
                 1
               /   \ 
             2       3
           /   \       \    
          4     5       2     
                       /  \    
                      4    5
  Output : 1
  Explanation : 
      2     
    /   \    
   4     5
  is the duplicate sub-tree.

Example 2 :
  Input : 
                 1
               /   \ 
             2       3
  Output: 0
  Explanation: There is no duplicate sub-tree in the given binary tree.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function dupSub() which takes root of the tree as the only arguement and returns 1 if the binary tree contains a duplicate sub-tree of size two or more, else 0.
Note: Two same leaf nodes are not considered as subtree as size of a leaf node is one.

Constraints:
1 ≤ length of string ≤ 100

*/


class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    int dupSub(Node root) {
        // code here 
        solve(root);
        for(Map.Entry<String, Integer> e : map.entrySet()) {
            if(e.getValue() >= 2) {
                return 1;
            }
        }
        
        return 0;
    }
    
    String solve(Node root) {
        if(root == null) {
            return "$";
        }
        StringBuilder sb = new StringBuilder("");
        if(root.left == null && root.right == null) {
            sb.append(String.valueOf(root.data));
            return new String(sb);
        }
        
        sb.append(String.valueOf(root.data));
        sb.append(solve(root.left));
        sb.append(solve(root.right));
        String s = new String(sb);
        map.put(s, map.getOrDefault(s, 0)+1);
        return s;
    }
}
