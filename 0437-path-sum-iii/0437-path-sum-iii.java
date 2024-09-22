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
    HashMap<Long, Integer> sumFreq = new HashMap<>();
    int pathCount = 0;
    public int pathSum(TreeNode root, int targetSum) {
        sumFreq.put((long)0, 1);
        helper(root, targetSum, 0);
        return pathCount;
    }

    void helper(TreeNode root, int targetSum, long sum) {
        if(root == null) {
            return;
        }

        sum += root.val;
        pathCount += sumFreq.getOrDefault(sum - targetSum, 0);
        sumFreq.put(sum, sumFreq.getOrDefault(sum, 0) + 1);
        helper(root.left, targetSum, sum);
        helper(root.right, targetSum, sum);
        sumFreq.put(sum, sumFreq.getOrDefault(sum, 0) - 1);
    }
}