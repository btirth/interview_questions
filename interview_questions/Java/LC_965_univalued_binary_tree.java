/*

A binary tree is univalued if every node in the tree has the same value.

Return true if and only if the given tree is univalued.

*/


class Solution {
    
    public boolean isUnivalTree(TreeNode root) {
        if(root==null) {
            return true;
        }
        return checkUT(root, root.val);
    }
    
    boolean checkUT(TreeNode root, int target) {
        if(root==null) {
            return true;
        }  
            
        if(root.val!=target) {
            return false;
        }
            
        return checkUT(root.right, target) && checkUT(root.left, target);
        
    }
}