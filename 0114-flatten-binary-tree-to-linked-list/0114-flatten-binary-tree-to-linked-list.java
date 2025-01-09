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
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        if(root.left != null) {
            stack.add(root);
        } else if(root.right != null) {
            stack.add(root.right);
        }
        

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.right != null) {
                stack.push(node.right);
            }

            while(node.left != null) {
                TreeNode next = node.left;
                root.right = node;
                root = root.right;
                node.left = null;
                node = next;

                if(node.right != null) {
                    stack.push(node.right);
                }
            }

            root.right = node;
            root = root.right;
        }
    }
}