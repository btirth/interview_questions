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

*/


//  Method 1

class Solution {
    List<Integer> ans = new LinkedList<Integer>();
    Stack<TreeNode> stack = new Stack<TreeNode>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) {
            return ans;
        }
        
        stack.push(root);
        
        
        while(!stack.empty()) {
            TreeNode t = stack.peek();
            if(t.val != 101) {
                ans.add(t.val);    
            }
            
            t.val = 101;
            
            if(t.left != null && t.left.val != 101) {
                stack.push(t.left);
                continue;
            }
            stack.pop();
            if(t.right != null) {
                stack.push(t.right);
                continue;
            }
            
        }
        
        return ans;
    }
}



//Method 2

class Solution {
    List<Integer> list = new LinkedList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) {
            return list;
        }
        
        traversal(root);
        
        return list;
    }
    
    public void traversal(TreeNode root) {
        if(root==null) {
            return;
        }
        
        list.add(root.val);
        if(root.left != null) {
            traversal(root.left);
        }
        if(root.right != null) {
            traversal(root.right);
        }
    }
    
}