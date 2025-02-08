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
        Queue<Pair<TreeNode, Long>> q = new LinkedList<>();
        q.add(new Pair(root, (long)1));
        int ans = 1;

        while(!q.isEmpty()) {
            int size = q.size();
            long left = Long.MAX_VALUE;
            long right = 0;

            for(int i=0; i<size; i++) {
                Pair<TreeNode, Long> p = q.poll();
                TreeNode node = p.getKey();
                long val = p.getValue();

                if(i == 0)
                    left = val;

                if(i == size-1)    
                    right = val;

                if(node.left != null) {
                    q.add(new Pair(node.left, (2 * val) + 1));
                }

                if(node.right != null) {
                    q.add(new Pair(node.right, (2 * val) + 2));
                }
            }

            ans = Math.max(ans, (int)(right - left + 1));
        }

        return ans;
    }
}