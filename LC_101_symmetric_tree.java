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
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        
        q1.add(root.left);
        q2.add(root.right);
        
        while(q1.size() != 0 && q2.size() != 0) {
            int size1 = q1.size();
            int size2 = q2.size();
            if(size1 != size2) {
                return false;
            }
            
            while(size1 > 0) {
                TreeNode n1 = q1.poll();
                TreeNode n2 = q2.poll();
                
                if(n1 == null && n2 == null) {
                    size1--;
                    continue;
                } else if(n1==null || n2 == null) {
                    return false;
                } else {
                    if(n1.val != n2.val) {
                        return false;
                    }
                    q1.add(n1.left);
                    q1.add(n1.right);
                    
                    q2.add(n2.right);
                    q2.add(n2.left);
                }
                size1--;
            }
        }
        return q1.size() == q2.size();
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
