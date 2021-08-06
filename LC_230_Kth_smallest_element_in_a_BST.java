/*

 Given the root of a binary search tree, and an integer k, return the kth (1-indexed) smallest element in the tree.

Example 1:
  Input: root = [3,1,4,null,2], k = 1
  Output: 1

Example 2:
  Input: root = [5,3,6,2,4,null,null,1], k = 3
  Output: 3
 
Constraints:
  The number of nodes in the tree is n.
  1 <= k <= n <= 10^4
  0 <= Node.val <= 10^4
 
Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?

*/



class Solution {
    int K;
    public int kthSmallest(TreeNode root, int k) {
        K = k;
        return helper(root);
    }
    int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = helper(root.left);
        if(left != 0) {
            return left;
        }
        K--;
        if(K==0) {
            return root.val;
        }
        int right = helper(root.right);
        return right;
    }
}
