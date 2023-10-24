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

    public List<Integer> largestValues(TreeNode root) {
        helper(root, 0);
        return ans;
    }

    void helper(TreeNode root, int level) {
        if(root == null) {
            return;
        }

        if(ans.size() <= level) {
            ans.add(root.val);
        } else {
            ans.set(level, Math.max(root.val, ans.get((Integer) level)));
        }

        if(root.left != null) {
            helper(root.left, level+1);
        }

        if(root.right != null) {
            helper(root.right, level+1);
        }
    }
}