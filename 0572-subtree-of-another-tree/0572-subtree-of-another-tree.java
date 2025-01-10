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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String rootFlatten = "-" + flattenTree(root);
        String subFlatten = "-" + flattenTree(subRoot);

        return rootFlatten.indexOf(subFlatten) != -1;
    }

    String flattenTree(TreeNode root) {
        if(root == null) {
            return "-";
        }

        String flattenValue = root.val + "-";
        flattenValue += flattenTree(root.left) + "-";
        flattenValue += flattenTree(root.right) + "-";
        return flattenValue;
    }
}