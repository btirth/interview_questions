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

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        TreeNode curr = null;
        while(!st.isEmpty()) {
            curr = st.pop();

            if(curr.right != null) {
                st.push(curr.right);
            }

            if(curr.left != null) {
                st.push(curr.left);
            }

            curr.left = null;
            if(!st.isEmpty()) {  
                curr.right = st.peek();
            }
        }
    }
}