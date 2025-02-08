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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;

        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        
        while(!st.isEmpty() || node != null) {
            TreeNode next = node.left;
            st.push(node);
            node = next;

            while(node == null && !st.isEmpty()) {
                TreeNode n = st.pop();
                ans.add(n.val);
                node = n.right;
            }
        }



        return ans;
    }
}