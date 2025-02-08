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
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = findLeftHeight(root.left);
        int right = findRightHeight(root.right);
        int levels = left + 1;

        if(left == right) {
            // for complete levels, no. of nodes = (2^levels - 1)
            return (1 << levels) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    int findLeftHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return 1 + findLeftHeight(root.left);
    }

    int findRightHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return 1 + findRightHeight(root.right);
    }
}