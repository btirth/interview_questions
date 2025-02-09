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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null) {
            return ans;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            level++;
            List<Integer> curr = new ArrayList<>();

            while(size-- > 0) {
                TreeNode node = q.poll();
                if(node.left != null) {
                    q.add(node.left);
                }

                if(node.right != null) {
                    q.add(node.right);
                }

                curr.add(node.val);
            }


            if(level%2 == 1) {
                ans.add(curr);
            } else {
                Collections.reverse(curr);
                ans.add(curr);
            }
        }

        return ans;
    }
}