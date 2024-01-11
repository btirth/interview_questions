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
    int ans = 0;
    public int maxAncestorDiff(TreeNode root) {
        if(root == null) {
            return 0;
        }
         
        dfs(root.left, root.val, Integer.MAX_VALUE);
        dfs(root.right, root.val, Integer.MAX_VALUE);
        return ans;
    }

    void dfs(TreeNode root, int p1, int p2) {
        if(root == null) {
            return;
        }

        if(p1 != Integer.MAX_VALUE) {
            ans = Math.max(ans, Math.abs(root.val - p1));
        }

        if(p2 != Integer.MAX_VALUE) {
            ans = Math.max(ans, Math.abs(root.val - p2));
        }

        dfs(root.left, Math.max(p1, root.val), Math.min(p2, root.val));
        dfs(root.right, Math.max(p1, root.val), Math.min(p2, root.val));
    }
}