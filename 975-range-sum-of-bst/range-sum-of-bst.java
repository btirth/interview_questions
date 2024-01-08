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
    public int rangeSumBST(TreeNode root, int low, int high) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int sum = 0;
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node == null) {
                continue;
            }
            if(node.val >= low && node.val <= high) {
                sum += node.val;
                q.add(node.left);
                q.add(node.right);
            } else if(node.val < low || node.val < high) {
                q.add(node.right);
            } else {
                q.add(node.left);
            }
        }

        return sum;
    }
}