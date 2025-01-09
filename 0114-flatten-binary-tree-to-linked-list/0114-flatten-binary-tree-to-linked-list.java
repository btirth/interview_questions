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
        prev = new TreeNode();
        if(root == null) {
            return;
        }
        flattenTree(root);
    }

    TreeNode prev;
    void flattenTree(TreeNode tree) {
        if(tree == null) {
            return;
        }

        TreeNode left = tree.left;
        TreeNode right = tree.right;
        tree.left = null;
        tree.right = null;
        prev.right = tree;
        prev = prev.right;
       
        flattenTree(left);
        flattenTree(right);
    }
}