/*

Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

Example 1:
  Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
  Output: [3,9,20,null,null,15,7]

Example 2:
  Input: inorder = [-1], postorder = [-1]
  Output: [-1]

Constraints:
  1 <= inorder.length <= 3000
  postorder.length == inorder.length
  -3000 <= inorder[i], postorder[i] <= 3000
  inorder and postorder consist of unique values.
  Each value of postorder also appears in inorder.
  inorder is guaranteed to be the inorder traversal of the tree.
  postorder is guaranteed to be the postorder traversal of the tree.

*/



class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }
    
    TreeNode helper(int[] inorder, int[] postorder, int inS, int inE, int postS, int postE) {
        if(inS > inE) {
            return null;
        }
        
        int rootVal = postorder[postE];
        TreeNode root = new TreeNode(rootVal);
        
        int rootIndex = -1;
        for(int i=inS; i<=inE; i++){
            if(inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        
        int lInS = inS;
        int lInE = rootIndex-1;
        int lPostS = postS;
        int lPostE = (lInE - lInS) + lPostS;
        
        int rInS = rootIndex+1;
        int rInE = inE;
        int rPostS = lPostE + 1;
        int rPostE = postE-1;
        
        root.left = helper(inorder, postorder, lInS, lInE, lPostS, lPostE);
        root.right = helper(inorder, postorder, rInS, rInE, rPostS, rPostE);
        return root;
    }
}
