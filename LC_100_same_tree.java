/*

Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

Example 1:
  Input: p = [1,2,3], q = [1,2,3]
  Output: true

Example 2:
  Input: p = [1,2], q = [1,null,2]
  Output: false

Example 3:
  Input: p = [1,2,1], q = [1,1,2]
  Output: false
 
Constraints:
  The number of nodes in both trees is in the range [0, 100].
  -10^4 <= Node.val <= 10^4

*/


class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null || q==null) {
            return p == q;
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        
        q1.add(p);
        q2.add(q);
        
        while(q1.size() != 0 && q2.size() != 0) {
            int size1 = q1.size();
            int size2 = q2.size();
            if(size1 != size2) {
                return false;
            }
            
            while(size1 > 0) {
                TreeNode node1 = q1.poll();
                TreeNode node2 = q2.poll();
                if(node1 == null) {
                    if(node2 != null) {
                        return false;
                    }    
                } else if(node2 == null) {
                    if(node1 != null) {
                        return false;
                    }
                } else if(node1.val != node2.val) {
                    return false;
                }
                
                if(node1 != null) {
                    q1.add(node1.left);
                    q1.add(node1.right);
                }
                
                if(node2 != null) {
                    q2.add(node2.left);
                    q2.add(node2.right);    
                } 
                size1--;
            }
        }
        return q1.size() == q2.size();
    }
}



// Recursive Approach
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        
        if(p==null || q == null) {
            return false;
        }
        
        if(p.val != q.val) {
            return false;
        }
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
