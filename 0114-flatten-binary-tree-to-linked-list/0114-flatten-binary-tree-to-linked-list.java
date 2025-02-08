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

    TreeNode[] helper(TreeNode root) {
        if(root == null) {
            return new TreeNode[2];
        }

        TreeNode[] left = helper(root.left);
        TreeNode[] right = helper(root.right);
        TreeNode last = root;

        root.left = null;
        if(left[0] != null) {
            last.right = left[0];
            last = left[1];
        }

        if(right[0] != null) {
            last.right = right[0];
            last = right[1];
        }
            

        return new TreeNode[]{root, last};
    }
}