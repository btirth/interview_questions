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
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return maxDiameter - 1;
    }

    int diameter(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = diameter(root.left);
        int right = diameter(root.right);

        int diameter = 1 + left + right;
        maxDiameter = Math.max(maxDiameter, diameter);
        return 1 + Math.max(left, right);
    }
}