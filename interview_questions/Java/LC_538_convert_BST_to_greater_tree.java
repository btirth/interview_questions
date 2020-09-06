/*

Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

Example:

Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13

*/


class Solution {
    public TreeNode convertBST(TreeNode root) {
        if(root==null) {
            return root;
        }
        changeRoot(root, 0);
        return root;
    }
    
    int changeRoot(TreeNode root, int count) {
        int countGreatValue=count;
        if(root.right!=null) {
            countGreatValue = changeRoot(root.right, countGreatValue);   
        }
        root.val = root.val+countGreatValue;
        countGreatValue = root.val;
        if(root.left!=null) {
            countGreatValue = changeRoot(root.left, countGreatValue);    
        }
        return countGreatValue;
    }
    
    
}