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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }

    TreeNode helper(int[] io, int[] po, int is, int ie, int ps, int pe) {
        if(is > ie || ps > pe) {
            return null;
        }

        if(is == ie) {
            return new TreeNode(io[is]);
        }

        int rootVal = po[pe];
        int idx = is;
        for(; idx <= ie; idx++) {
            if(io[idx] == rootVal) {
                break;
            }
        }

        int lis = is;
        int lie = idx - 1;
        int ris = idx + 1;
        int rie = ie;

        int lps = ps;
        int lpe = ps + (lie - lis);
        int rps = lpe + 1;
        int rpe = pe - 1;

        TreeNode root = new TreeNode(rootVal);
        root.left = helper(io, po, lis, lie, lps, lpe);
        root.right = helper(io, po, ris, rie, rps, rpe);

        return root;
    }
}