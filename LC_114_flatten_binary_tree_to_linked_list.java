/*

Given the root of a binary tree, flatten the tree into a "linked list":
  The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
  The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 
Example 1:
  Input: root = [1,2,5,3,4,null,6]
  Output: [1,null,2,null,3,null,4,null,5,null,6]

Example 2:
  Input: root = []
  Output: []

Example 3:
  Input: root = [0]
  Output: [0]
 
Constraints:
  The number of nodes in the tree is in the range [0, 2000].
  -100 <= Node.val <= 100
 
Follow up: Can you flatten the tree in-place (with O(1) extra space)?

*/


class Solution {
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        
        TreeNode curr = root;
        while(curr != null) {
            if(curr.left != null) {
                TreeNode prev = curr.left;
                while(prev.right != null) {
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}




class Solution {
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()) {
            TreeNode curr_node = stack.pop();
            if(curr_node.right != null) {
                stack.push(curr_node.right);
            }
            
            if(curr_node.left != null) {
                stack.push(curr_node.left);
            }
            
            if(!stack.empty()) {
                curr_node.right = stack.peek();
            }
            curr_node.left = null;
        }
    }
}




class Solution {
    TreeNode prev;
    
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        prev = root;
        TreeNode tempLeft = root.left;
        TreeNode tempRight = root.right;
        
        helper(tempLeft);
        helper(tempRight);
        
    }
    
    void helper(TreeNode root) {
        if(root == null) {
            return;
        }
        
        TreeNode tempLeft = root.left;
        TreeNode tempRight = root.right;
        
        prev.right = root;
        prev.left = null;
        prev = prev.right;
  
        helper(tempLeft);
        helper(tempRight);    
        
    }
}



class Solution {
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        
        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;
        
        while(root.right != null) {
            root = root.right;
        }
        root.right = right;
    }
}




