/*

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

Example 1:
  Input: root = [3,9,20,null,null,15,7]
  Output: true

Example 2:
  Input: root = [1,2,2,3,3,null,null,4,4]
  Output: false

Example 3:
  Input: root = []
  Output: true
 
Constraints:
  The number of nodes in the tree is in the range [0, 5000].
  -10^4 <= Node.val <= 10^4

*/



class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        return getHeight(root) != -1;
    }
    
    int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int left = 0;
        int right = 0;
        if(root.left != null) {
            left = getHeight(root.left);
            if(left == -1) {
                return -1;
            }
        }
        if(root.right != null) {
            right = getHeight(root.right);
            if(right == -1) {
                return -1;
            }
        }
        if(Math.abs(right-left) > 1) {
            return -1;
        }
        return Math.max(left, right)+1;
    }
}
