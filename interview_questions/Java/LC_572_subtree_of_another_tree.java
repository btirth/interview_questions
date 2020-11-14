/*
Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
 

Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.

*/

class Solution {
    
    public String tree2str(TreeNode t) {
        if(t==null) {
            return new String();
        }
        
        StringBuilder result = new StringBuilder(Integer.toString(t.val));
        if(t.left == null) {
            result.append('X');
        } else {
            result.append(tree2str(t.left));
        }
        
        if(t.right == null) {
            result.append('X');
        } else {
            result.append(tree2str(t.left));
        }
        
        return new String(result);
    }
    
    public boolean isSubtree(TreeNode s, TreeNode t) {
        
        if(t==null) {
            return true;
        }
        
        if(s==null) {
            System.out.println("d");
            return false;
        }
        
        if(s.val == t.val) {
            System.out.println("d\\");
            String strS = tree2str(s);
            String strT = tree2str(t);
            System.out.println(strS + " "+strT);
            return strS.equals(strT);
        }
        
        return isSubtree(s.left, s) || isSubtree(s.right, s);
    }
}