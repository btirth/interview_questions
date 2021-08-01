/*

Given the root of a binary tree, return the preorder traversal of its nodes' values.

Example 1:
  Input: root = [1,null,2,3]
  Output: [1,2,3]

Example 2:
  Input: root = []
  Output: []

Example 3:
  Input: root = [1]
  Output: [1]

Example 4:
  Input: root = [1,2]
  Output: [1,2]

Example 5:
  Input: root = [1,null,2]
  Output: [1,2]
 
Constraints:
  The number of nodes in the tree is in the range [0, 100].
  -100 <= Node.val <= 100
 
Follow up: Recursive solution is trivial, could you do it iteratively?

*/



// Iteratively
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.empty()) {
            TreeNode cur = st.pop();
            ans.add(cur.val);
            if(cur.right != null) {
                st.push(cur.right);
            }
            if(cur.left != null) {
                st.push(cur.left);
            }
        }
        return ans;
    }
}



// Recursive
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if(root == null) {
            return ans;
        }
        preorderTraversal(root, ans);
        return ans;
    }
    
    void preorderTraversal(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }
        
        list.add(root.val);
        
        if(root.left != null) {
            preorderTraversal(root.left, list);
        }
        
        if(root.right != null) {
            preorderTraversal(root.right, list);
        }
    }
}
