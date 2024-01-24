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
    int[] freq = new int[10];
    int oddCount = 0;
    int ans = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        helper(root);
        return ans;
    }

    void helper(TreeNode root) {
        if(root == null) {
            return;
        }

        freq[root.val]++;
        if(freq[root.val]%2 == 1) {
            oddCount++;
        } else {
            oddCount--;
        }

        if(root.left == null && root.right == null) {
            if(oddCount == 0 || oddCount == 1) {
                ans++;
            }
        }

        helper(root.left);
        helper(root.right);

        freq[root.val]--;
        if(freq[root.val]%2 == 1) {
            oddCount++;
        } else {
            oddCount--;
        }
    }
}