/*

Given the root of a binary tree, return the postorder traversal of its nodes' values.

 
Example 1:
    Input: root = [1,null,2,3]
    Output: [3,2,1]

Example 2:
    Input: root = []
    Output: []

Example 3:
    Input: root = [1]
    Output: [1]

Example 4:
    Input: root = [1,2]
    Output: [2,1]

Example 5:
    Input: root = [1,null,2]
    Output: [2,1]
 

Constraints:
    The number of the nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100

*/


// Method 1

class Solution {
    List<Integer> list = new LinkedList<Integer>();
    Stack<TreeNode> stack = new Stack<TreeNode>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) {
            return list;
        }
        
        stack.push(root);
        
        while(!stack.empty()) {
            TreeNode t  = stack.peek();
            if(t.left != null && t.left.val != 101) {
                stack.push(t.left);
                continue;
            } 
            if(t.right != null && t.right.val != 101) {
                stack.push(t.right);
                continue;
            }
            list.add(t.val);
            t.val = 101;
            stack.pop();
            
        }
        
        return list;
    }
}



//Method  2
class Solution {
    List<Integer> list = new LinkedList<Integer>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) {
            return list;
        }
        
        traversal(root);
        return list;
    }
    
    public void traversal(TreeNode root) {
        if(root == null) {
            return;
        }
        
        if(root.left != null) {
            traversal(root.left);
        }
        if(root.right != null) {
            traversal(root.right);
        }
        list.add(root.val);
    }
    
}