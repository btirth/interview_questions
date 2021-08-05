/*

Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each path's sum equals targetSum.

A leaf is a node with no children.

Example 1:
  Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
  Output: [[5,4,11,2],[5,8,4,5]]

Example 2:
  Input: root = [1,2,3], targetSum = 5
  Output: []

Example 3:
  Input: root = [1,2], targetSum = 0
  Output: []
 
Constraints:
  The number of nodes in the tree is in the range [0, 5000].
  -1000 <= Node.val <= 1000
  -1000 <= targetSum <= 1000

*/



class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        helper(root, targetSum, res, new ArrayList<>());
        return res;
    }
    
    void helper(TreeNode root, int target, List<List<Integer>> res, List<Integer> list) {
        if(root == null) {
            return;
        }
        
        list.add(root.val);
        if(target == root.val && root.left == null && root.right == null) {
            res.add(new ArrayList<>(list));
        } else {
            helper(root.left, target-root.val, res, list);
            helper(root.right, target-root.val, res, list);    
        }
        
        list.remove(list.size()-1);
    }
}
