/*

Invert a binary tree.

Example:
Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1

*/


class Solution {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }
    
    void invert(TreeNode root) {
       if(root==null) {
           return;
       }
        
        TreeNode newRight = null;
        
        if(root.left != null) {
            invert(root.left);
        }
        
        newRight = root.left;  
        
        if(root.right != null) {
            invert(root.right);  
        }
        
        root.left = root.right;
        root.right = newRight;
    }
    
}