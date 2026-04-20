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
    int val = -1;
    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return val;
    }

    int helper(TreeNode root, int k) {
        if(root == null) {
            return k;
        }

        if(k > 0 && root.left != null) {
            // Explore left tree
            k = helper(root.left, k);
        }

        // Root
        k -= 1;
        if(k == 0) {
            val = root.val;
        }

        if(k>0 && root.right != null) {
            // Explore right tree
            k = helper(root.right, k);
        }

        return k;
    }
}