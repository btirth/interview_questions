/*

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3
 

Follow up: Solve it both recursively and iteratively.

*/




/* Method 1 */ 

class Solution {
    
    StringBuilder L = new StringBuilder("");
    StringBuilder R = new StringBuilder("");
    
    public boolean isSymmetric(TreeNode root) {
        
        if(root==null) {
            return true;
        } else if(root.left==null && root.right==null) {
            return true;
        } else if(root.left==null || root.right==null) {
            return false;
        } else if(root.left.val != root.right.val) {
            return false;
        }
        
        getL(root.left);
        getR(root.right);

        return L.toString().equals( R.toString() );
    }
    
    void getL(TreeNode root) {
        if(root==null) {
            L.append('X');
            return;
        }
        
        L.append(Integer.toString(root.val));
        
        getL(root.left);
        getL(root.right);
    }
    
    void getR(TreeNode root) {
        if(root==null) {
            R.append('X');
            return;
        }
        
        R.append(Integer.toString(root.val));
        
        getR(root.right);
        getR(root.left);
    }
}


/* Method 2 using Recursion*/

class Solution {
    public boolean isSymmetric(TreeNode root) {
        
        if(root==null) {
            return true;
        } else if(root.left==null && root.right==null) {
            return true;
        } else if(root.left==null || root.right==null) {
            return false;
        } else if(root.left.val != root.right.val) {
            return false;
        }
        
        return checkSymmentric(root.left, root.right);
    }
    
    boolean checkSymmentric(TreeNode L, TreeNode R) {
        if(L==null && R==null) {
            return true;
        } else if(L==null || R==null) {
            return false;
        } else if(L.val != R.val) {
            return false;
        }
        
        return checkSymmentric(L.left, R.right) && checkSymmentric(L.right, R.left);
    }
}


/* Method 3 using Iteration*/
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) {
            return true;
        } else {
            Queue<TreeNode> q = new LinkedList<TreeNode>();
            q.add(root.left);
            q.add(root.right);
            
            while(!q.isEmpty()) {
                TreeNode n1 = q.poll();
                TreeNode n2 = q.poll();
                
                if(n1==null && n2==null) {
                    continue;
                } else if(n1==null || n2==null) {
                    return false;
                } else if(n1.val!=n2.val) {
                    return false;
                } else {
                    q.add(n1.left);
                    q.add(n2.right);
                    
                    q.add(n1.right);
                    q.add(n2.left);
                }
            }
        }
        
        return true;
    }
}