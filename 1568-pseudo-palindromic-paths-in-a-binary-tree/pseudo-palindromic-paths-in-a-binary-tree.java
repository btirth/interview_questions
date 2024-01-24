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
    int ans = 0;
    List<Integer> oddVal = new ArrayList<>();
    public int pseudoPalindromicPaths (TreeNode root) {
        helper(root);
        return ans;
    }

    void helper(TreeNode root) {
        if(root == null) {
            return;
        }

        if(oddVal.contains(root.val)) {
            oddVal.remove((Integer)root.val);
        } else {
            oddVal.add(root.val);
        }

        if(root.left == null && root.right == null) {
            if(oddVal.size() == 0 || oddVal.size() == 1) {
                ans++;
            }
        }

        helper(root.left);
        helper(root.right);
        
        if(oddVal.contains(root.val)) {
            oddVal.remove((Integer)root.val);
        } else {
            oddVal.add(root.val);
        }
    }
}