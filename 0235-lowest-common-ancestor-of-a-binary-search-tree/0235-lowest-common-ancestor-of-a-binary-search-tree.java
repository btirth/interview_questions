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

        while(root != null) {
            if(root.val == p.val || root.val == q.val || (root.val > p.val && root.val < q.val)) {
                // this is ans
                return root;
            } else if(root.val < p.val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return null;
    }
}