/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > q.val) {
            return lowestCommonAncestor(root, q, p);
        }
        TreeNode node = root;

        while(node != null) {

            if(node.val >= p.val && node.val <= q.val) {
                return node;
            }

            if(node.val >= p.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        return node;
    }
}