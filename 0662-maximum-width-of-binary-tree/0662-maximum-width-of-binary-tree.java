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
        q.add(new Pair(root, 1));
        int ans = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            int leftmostPos = 0;
            int rightmostPos = 0;

            for(int i=0; i<size; i++) {
                Pair<TreeNode, Integer> nodePos = q.poll();
                TreeNode node = nodePos.getKey();
                int pos = nodePos.getValue();

                if(i == 0) {
                    leftmostPos = pos;
                }

                if(i == size - 1) {
                    rightmostPos = pos;
                }

                int leftPos = (2 * pos) - 1;
                int rightPos = (2 * pos);

                if(node.left != null) {
                    q.add(new Pair(node.left, leftPos));
                }

                if(node.right != null) {
                    q.add(new Pair(node.right, rightPos));
                }

                
            } 

            ans = Math.max(ans, rightmostPos - leftmostPos + 1);
        }

        return ans;
    }
}