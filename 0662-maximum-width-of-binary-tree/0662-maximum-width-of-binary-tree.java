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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        int ans = 1;

        while(!q.isEmpty()) {
            int size = q.size();
            int left = 0;
            int right = 0;

            for(int i=0; i<size; i++) {
                Pair<TreeNode, Integer> p = q.poll();
                TreeNode node = p.getKey();
                int val = p.getValue();

                if(i == 0)
                    left = val;

                if(i == size-1)    
                    right = val;

                if(node.left != null) {
                    q.add(new Pair(node.left, (2 * val)));
                }

                if(node.right != null) {
                    q.add(new Pair(node.right, (2 * val) + 1));
                }
            }

            ans = Math.max(ans, (right - left + 1));
        }

        return ans;
    }
}