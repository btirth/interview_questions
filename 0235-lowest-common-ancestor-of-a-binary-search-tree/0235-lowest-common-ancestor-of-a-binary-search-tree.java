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
        if(p.val>q.val) {
            return helper(root, q, p);
        }
        
        return helper(root, p, q);
    }

    TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }

        if(root.val == p.val || root.val == q.val || (root.val > p.val && root.val < q.val)) {
            // this is ans
            return root;
        } else if(root.val < p.val) {
            return helper(root.right, p, q);
        } else {
            return helper(root.left, p, q);
        }
    }
}