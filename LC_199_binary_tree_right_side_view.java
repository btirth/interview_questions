/*

Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example 1:
  Input: root = [1,2,3,null,5,null,4]
  Output: [1,3,4]

Example 2:
  Input: root = [1,null,3]
  Output: [1,3]

Example 3:
  Input: root = []
  Output: []
 
Constraints:
  The number of nodes in the tree is in the range [0, 100].
  -100 <= Node.val <= 100

*/


class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            int last = -1;
            while(size-- > 0) {
                TreeNode node = queue.poll();
                last = node.val;
                if(node.left != null) {
                    queue.add(node.left);
                }
                
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            
            res.add(last);
        }
        
        return res;
    }
}
