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
    public boolean isBalanced(TreeNode root) {
        int[] res = helper(root);
        return res[1] == 0;
    }

    int[] helper(TreeNode root) {
        if(root == null) {
            return new int[]{0,0};
        }

        int[] left = helper(root.left);
        int[] right = helper(root.right);

        if(left[1] == 1 || right[1] == 1 || Math.abs(left[0] - right[0]) > 1) {
            return new int[]{0,1};
        }

        return new int[]{Math.max(left[0], right[0]) + 1, 0};
    }
}