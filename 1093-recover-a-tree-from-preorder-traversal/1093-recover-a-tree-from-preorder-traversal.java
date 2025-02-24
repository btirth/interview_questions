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
    TreeNode[] levels = new TreeNode[1001];
    public TreeNode recoverFromPreorder(String traversal) {
        helper(traversal, 0, 0);
        return levels[0];
    }

    void helper(String traversal, int idx, int steps) {
        if(idx >= traversal.length()) {
            return;
        }
        
        if(traversal.charAt(idx) == '-') {
            helper(traversal, idx + 1, steps + 1);
            return;
        } 

        StringBuilder val = new StringBuilder("");

        while(idx < traversal.length() && traversal.charAt(idx) != '-') {
            val.append(traversal.charAt(idx));
            idx++;
        }

        TreeNode node = new TreeNode(Integer.valueOf(val.toString()));
        
        if(steps == 0) {
            levels[0] = node;
            helper(traversal, idx, 0);
            return;
        }

        TreeNode root = levels[steps - 1];
        
        if(root.left == null) {
            root.left = node;
        } else {
            root.right = node;
        }

        levels[steps] = node;

        helper(traversal, idx, 0);
    }
}