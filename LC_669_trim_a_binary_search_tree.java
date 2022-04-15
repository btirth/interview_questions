/*

Given the root of a binary search tree and the lowest and highest boundaries as low and high, trim the tree so that all its elements lies in [low, high]. Trimming the tree should not change the relative structure of the elements that will remain in the tree (i.e., any node's descendant should remain a descendant). It can be proven that there is a unique answer.

Return the root of the trimmed binary search tree. Note that the root may change depending on the given bounds.

Example 1:
  Input: root = [1,0,2], low = 1, high = 2
  Output: [1,null,2]

Example 2:
  Input: root = [3,0,4,null,2,null,null,1], low = 1, high = 3
  Output: [3,2,null,1]
 
Constraints:
  The number of nodes in the tree in the range [1, 10^4].
  0 <= Node.val <= 10^4
  The value of each node in the tree is unique.
  root is guaranteed to be a valid binary search tree.
  0 <= low <= high <= 10^4

*/


class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        //if the range is correct then checking both root left and right
        if (root.val >= L && root.val <= R) {
            root.left = trimBST(root.left, L, R);//Trim the left subtree
            root.right = trimBST(root.right, L, R);//Trim the right subtree
        } else if (root.val < L) {
            //if the root val is less than low then getting values from left will be even lower(binary tree rule) so we need to set the root to root.right;
            root = trimBST(root.right, L, R);
        } else if (root.val > R) {
            //if the root val is greater than high then getting values from right will be even higher(binary tree rule) so we need to the root to root.left.
            root = trimBST(root.left, L, R);
        }
        return root;
    }
}
