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
    int ans = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        helper(root.left, root.val, root.val);
        helper(root.right, root.val, root.val);
        return ans;
    }

    void helper(TreeNode root, int min, int max) {
        if(root == null) {
            return;
        }

        ans = Math.min(ans, Math.min(Math.abs(root.val-min), Math.abs(max-root.val)));
        helper(root.left, min, root.val);
        helper(root.right, root.val, max);
    }
}