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
        TreeNode[] pair = helper(root, p, q);
        return pair[0];
    }

    TreeNode[] helper(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null) {
            return new TreeNode[2];
        }
        
        TreeNode[] pair = new TreeNode[2];
        if(root.val == p.val) {
            pair[0] = root;
        }

        if(root.val == q.val) {
            pair[1] = root;
        }

        TreeNode[] pair1 = helper(root.left, p, q);
        if(pair1[0] != null) {
            pair[0] = pair1[0];
        } 
        
        if(pair1[1] != null) {
            pair[1] = pair1[1];
        }

        if(pair[0] != null && pair[0] == pair[1]) {
            return pair;
        }

        if(pair[0] != null && pair[1] != null) {
            return new TreeNode[]{root, root};
        } 

        TreeNode[] pair2 = helper(root.right, p, q);
        if(pair2[0] != null && pair2[0] == pair2[1]) {
            return pair2;
        }

        if(pair2[0] != null) {
            pair[0] = pair2[0];
        } 
        
        if(pair2[1] != null) {
            pair[1] = pair2[1];
        }

        if(pair[0] != null && pair[0] == pair[1]) {
            return pair;
        }

        if(pair[0] != null && pair[1] != null) {
            return new TreeNode[]{root, root};
        } 

        return pair;
    }
}