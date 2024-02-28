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
    int depth;
    int ans;
    public int findBottomLeftValue(TreeNode root) {
        depth = 0;
        ans = 0;
        helper(root, 1);
        return ans;
    }

    void helper(TreeNode root, int level) {
        if(root == null) {
            return;
        }

        if(root.left == null && root.right == null) {
            if(level > depth) {
                depth = level;
                ans = root.val;
            }
            return;
        }

        helper(root.left, level+1);
        helper(root.right, level+1);
    }
}