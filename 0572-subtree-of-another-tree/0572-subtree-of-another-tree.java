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
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node.val == subRoot.val && isSameTree(node, subRoot)) {
                return true;
            }

            if(node.left != null)
                q.add(node.left);
            
            if(node.right != null)
                q.add(node.right);
        }

        return false;
    }

    boolean isSameTree(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null) {
            return root1 == null && root2 == null;
        }  

        if(root1.val != root2.val) {
            return false;
        }

        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }
}