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
        List<Integer> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size() != 0) {
            int size = q.size();
            while(size > 0) {
                TreeNode node = q.poll();
                if(ans.size() <= level) {
                    ans.add(-101);
                }
                ans.set(level,node.val);
                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
                size--;
            }
            level++;
        }
        return ans;
    }
}
