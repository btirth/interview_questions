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
    List<Integer> ans = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        traversal(root);
        return ans;
    }

    void traversal(TreeNode root) {
        if(root == null) {
            return;
        }

        if(root.left != null) {
            traversal(root.left);
        }

        ans.add(root.val);

        if(root.right != null) {
            traversal(root.right);
        }
    }
}