/*

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Example 1:
  Input: root = [1,2,2,3,4,4,3]
  Output: true

Example 2:
  Input: root = [1,2,2,null,3,null,3]
  Output: false

Constraints:
  The number of nodes in the tree is in the range [1, 1000].
  -100 <= Node.val <= 100
 
Follow up: Could you solve it both recursively and iteratively?

*/


// Iteratively

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
    public boolean isSymmetric(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) {
            return true;
        }
        
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        
        q1.add(root.left);
        q2.add(root.right);
        
        while(!q1.isEmpty()) {
            TreeNode n1 = q1.poll();
            TreeNode n2 = q2.poll();
            
            if(n1 == null && n2 == null) {
                continue;
            }
            
            if(n1 == null || n2 == null) {
                return false;
            }
            if(n1.val != n2.val) {
                return false;
            }
            
            q1.add(n1.left);
            q1.add(n1.right);
            
            q2.add(n2.right);
            q2.add(n2.left);
        }
        
        return true;
    }
}


// Recursively
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        
        return isSymmetric(root.left, root.right);
    }
    
    boolean isSymmetric(TreeNode n1, TreeNode n2) {
        if(n1 == null && n2 == null) {
            return true;
        } else if(n1 == null || n2 == null) {
            return false;
        }
        
        return n1.val == n2.val && isSymmetric(n1.left, n2.right) && isSymmetric(n1.right, n2.left);
    }
}
