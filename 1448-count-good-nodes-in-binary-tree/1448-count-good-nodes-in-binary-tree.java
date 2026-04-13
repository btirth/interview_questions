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
    public int goodNodes(TreeNode root) {
        return goodNodes(root, Integer.MIN_VALUE);
    }

    int goodNodes(TreeNode root, int maxVal) {
        if(root == null) {
            return 0;
        }

        int val = root.val >= maxVal ? 1 : 0;
        maxVal = Math.max(maxVal, root.val);
        val += goodNodes(root.left, maxVal);
        val += goodNodes(root.right, maxVal);

        return val;
    }
}