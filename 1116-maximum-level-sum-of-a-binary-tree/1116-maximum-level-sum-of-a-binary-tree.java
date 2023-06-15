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
    public int maxLevelSum(TreeNode root) {
        int maxSumLevel = 1;
        int maxSum = root.val;
        int currLevel = 1;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            int sum = 0;
            while(size-- > 0) {
                TreeNode node = q.poll();
                sum += node.val;

                if(node.left != null) {
                    q.add(node.left);
                }

                if(node.right != null) {
                    q.add(node.right);
                }
            }

            if(sum > maxSum) {
                maxSum = sum;
                maxSumLevel = currLevel;
            }
            
            currLevel++;
        }

        return maxSumLevel;
    }
}