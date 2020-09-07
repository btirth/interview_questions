/*

Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:
    Input:

       1
     /   \
    2     3
     \
      5

    Output: ["1->2->5", "1->3"]
    Explanation: All root-to-leaf paths are: 1->2->5, 1->3


*/


class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        return path(root);
    }
    
    List<String> path(TreeNode root) {
        if(root==null) return new ArrayList<String>();
        List<String> list = new ArrayList<String>();
        
        if(root.left==null && root.right==null) {
            list.add(String.valueOf(root.val));
            return list;
        }
        
        list.addAll(path(root.left));
        list.addAll(path(root.right));
        
        for(int i=0; i<list.size(); i++) {
            list.set(i,String.valueOf(root.val)+"->"+list.get(i));
        }    
         
        return list;
    }
}