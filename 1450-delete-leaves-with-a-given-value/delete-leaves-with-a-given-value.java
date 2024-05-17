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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return helper(root, target); 
    }

    TreeNode helper(TreeNode root, int target) {
        if(root == null) {
            return null;
        }

        if(root.left == null && root.right == null && root.val == target) {
            return null;
        }

        TreeNode left = helper(root.left, target);
        TreeNode right = helper(root.right, target);

        if(left == null && right == null && root.val == target) {
            return null;
        }

        if(left == null) {
            root.left = null;
        }

        if(right == null) {
            root.right = null;
        }

        return root;
    }
}