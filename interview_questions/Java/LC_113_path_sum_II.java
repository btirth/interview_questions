/*

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:    
    Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1

Return:
    [
        [5,4,11,2],
        [5,8,4,5]
    ]

*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        pathSum(root, sum, new ArrayList<Integer>(), res);
        return res;
    }
    
    void pathSum(TreeNode root, int sum, List<Integer> sol, List<List<Integer>> res) {
        if(root == null) {
            return;
        }
        
        sol.add(root.val);
        if(root.left==null && root.right==null && root.val==sum) {
            res.add(new ArrayList<Integer>(sol));
        } else {
            pathSum(root.left, sum-root.val, sol, res);
            pathSum(root.right, sum-root.val, sol, res);
        }
        sol.remove(sol.size() - 1);
    }
}