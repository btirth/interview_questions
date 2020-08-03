/*

Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:
    Input:     1         1
              / \       / \
             2   3     2   3

            [1,2,3],   [1,2,3]

    Output: true

Example 2:
    Input:     1         1
              /           \
             2             2

            [1,2],     [1,null,2]

    Output: false

Example 3:
    Input:     1         1
              / \       / \
             2   1     1   2

            [1,2,1],   [1,1,2]

    Output: false

*/



class Solution {   
   public boolean isSameTree(TreeNode p, TreeNode q) {
        return sameRoot(p, q)==0;
    }
    
    int sameRoot(TreeNode p, TreeNode q) {
        int flag = 0; 
        if(p==null && q!=null) {
            return -1;
        }
        if(q==null && p!=null) {
            return -1;
        }
        if(p==null && q==null) {
            return 0;
        }
        if(p.val != q.val) {
            return -1;
        }
        
        flag = sameRoot(p.left, q.left);
        if(flag!=0) {
            return -1;
        }
        flag = sameRoot(p.right, q.right);
        
        return flag;
    }
    
}