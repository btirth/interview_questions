/*

Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Example 1:
  Input: root = [3,9,20,null,null,15,7]
  Output: [[3],[9,20],[15,7]]

Example 2:
  Input: root = [1]
  Output: [[1]]

Example 3:
  Input: root = []
  Output: []
 
Constraints:
  The number of nodes in the tree is in the range [0, 2000].
  -1000 <= Node.val <= 1000

*/


class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            while(size-- > 0) {
                TreeNode node = queue.poll();
                level.add(node.val);
                
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            
            res.add(level);
        }
        
        return res;
    }
}
