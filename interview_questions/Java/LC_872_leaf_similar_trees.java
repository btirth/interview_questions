/*

Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.

For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

Example 1:
    Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
    Output: true

Example 2:
    Input: root1 = [1], root2 = [1]
    Output: true

Example 3:
    Input: root1 = [1], root2 = [2]
    Output: false

Example 4:
    Input: root1 = [1,2], root2 = [2,2]
    Output: true

*/

class Solution {
    int index1 = 0;
    int index2 = 0;
    ArrayList<Integer> leafs = new ArrayList<Integer>();
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        findLeaf(root1);
        return checkLeaf(root2);
    }
    
    void findLeaf(TreeNode root) {
        if(root.right==null && root.left==null) {
            leafs.add(root.val);
            index1 += 1;    
        } else {
            if(root.left!=null) {
                findLeaf(root.left);    
            } 
            if(root.right!=null){
                findLeaf(root.right);
            }     
        }
    }
    
    boolean checkLeaf(TreeNode root) {
        if(root.right==null && root.left==null) {
            if(index2>(index1-1)) return false;
            if(root.val != leafs.get(index2)) {
                return false;
            }
            index2 += 1;  
        } else {
            if(root.left!=null) {
                if(checkLeaf(root.left)==false) return false;    
            } 
            if(root.right!=null){
                if(checkLeaf(root.right)==false) return false;
            }     
        }
        return true;
    }
}