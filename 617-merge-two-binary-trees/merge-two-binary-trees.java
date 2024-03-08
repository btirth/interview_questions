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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return helper(root1, root2);
    }

    TreeNode helper(TreeNode r1, TreeNode r2) {
        if(r1 == null && r2 == null) {
            return null;
        }

        TreeNode r = null;
        if(r1 != null && r2 != null) {
            r = new TreeNode(r1.val + r2.val);
            r.left = helper(r1.left, r2.left);
            r.right = helper(r1.right, r2.right);
        }

        if(r1 == null) {
            r = r2;
        }

        if(r2 == null) {
            r = r1;
        }

        return r;
    }
}