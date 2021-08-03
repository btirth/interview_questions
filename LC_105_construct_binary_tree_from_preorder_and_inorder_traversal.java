/*

Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

Example 1:
  Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
  Output: [3,9,20,null,null,15,7]

Example 2:
  Input: preorder = [-1], inorder = [-1]
  Output: [-1]

Constraints:
  1 <= preorder.length <= 3000
  inorder.length == preorder.length
  -3000 <= preorder[i], inorder[i] <= 3000
  preorder and inorder consist of unique values.
  Each value of inorder also appears in preorder.
  preorder is guaranteed to be the preorder traversal of the tree.
  inorder is guaranteed to be the inorder traversal of the tree.

*/


class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
    
    public TreeNode helper(int[] preorder, int[] inorder, int preS, int preE, int inS, int inE) {
        if(inS > inE) {
            return null;
        }
        
        int rootVal = preorder[preS];
        TreeNode root = new TreeNode(rootVal);
        
        int rootIndex = -1;
        for(int i=inS; i<=inE; i++) {
            if(inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        
        int lInS = inS;
        int lInE = rootIndex-1;
        int lPreS = preS + 1;
        // lPreE - lPreS = lInE - lInS;
        int lPreE = (lInE - lInS) + lPreS;
        
        int rInS = rootIndex+1;
        int rInE = inE;
        int rPreS = lPreE + 1;
        int rPreE = preE;
        
        root.left = helper(preorder, inorder, lPreS, lPreE, lInS, lInE);
        root.right = helper(preorder, inorder, rPreS, rPreE, rInS, rInE);
        
        return root;
    }
}
