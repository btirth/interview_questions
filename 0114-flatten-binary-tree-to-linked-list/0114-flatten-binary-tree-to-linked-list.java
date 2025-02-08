/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        /**
        Root -> Left -> Right

        
        
         */

        helper(root);
    }

    TreeNode helper(TreeNode root) {
        if(root == null) {
            return null;
        }

        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);

        root.left = null;
        root.right = left;
        TreeNode curr = root;
        while(curr.right != null) {
            curr = curr.right;
        }
        curr.right = right;

        return root;
    }
}