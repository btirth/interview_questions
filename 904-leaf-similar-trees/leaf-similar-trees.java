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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();

        st1.add(root1);
        st2.add(root2);

        while(!st1.isEmpty() && !st2.isEmpty()) {
            TreeNode node1 = st1.peek();
            TreeNode node2 = st2.peek();
            if((node1.left==null && node1.right==null) && 
                (node2.left==null && node2.right==null)) {
                    st1.pop();
                    st2.pop();
                    if(node1.val != node2.val) {
                        return false;
                    }
                } 

            if(node1.left!=null || node1.right!=null) {
                st1.pop();

                if(node1.right != null) {
                    st1.add(node1.right);
                }

                if(node1.left != null) {
                    st1.add(node1.left);
                }
            }

            if(node2.left!=null || node2.right!=null) {
                st2.pop();

                if(node2.right != null) {
                    st2.add(node2.right);
                }
                
                if(node2.left != null) {
                    st2.add(node2.left);
                }
            }
        }

        return st1.isEmpty() && st2.isEmpty();
    }
}