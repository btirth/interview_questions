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
    public TreeNode buildTree(int[] in, int[] post) {
        return helper(in, post, 0, in.length-1, 0, post.length-1);
    }

    TreeNode helper(int[] in, int[] post, int inS, int inE, int postS, int postE) {
        if(postS > postE) {
            return null;
        }

        int rootIndex = inS;
        while(in[rootIndex] != post[postE]) {
            rootIndex++;
        }

        TreeNode root = new TreeNode(in[rootIndex]);

        int inLS = inS;
        int inLE = rootIndex-1;
        int postLS = postS;
        int postLE = postLS + inLE - inLS;

        int inRS = rootIndex + 1;
        int inRE = inE;
        int postRE = postE-1;
        int postRS = postRE - inRE + inRS;
        
        root.left = helper(in, post, inLS, inLE, postLS, postLE);
        root.right = helper(in, post, inRS, inRE, postRS, postRE);
        return root;
    }
}
