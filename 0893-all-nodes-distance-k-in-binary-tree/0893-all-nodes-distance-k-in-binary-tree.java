/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        helper(target, k);
        findNode(root, target, k);
        return ans;
    }

    int findNode(TreeNode root, TreeNode target, int k) {
        if(root == null) {
            return -1;
        }

        if(root.val == target.val) {
            return 1;
        }

        int left = findNode(root.left, target, k);
        if(left != -1) {
            if(k == left) {
                ans.add(root.val);
                return -1;
            }

            helper(root.right, k - left - 1);
            return left + 1;
        }

        int right = findNode(root.right, target, k);
        if(right != -1) {
            if(k == right) {
                ans.add(root.val);
                return -1;
            }

            helper(root.left, k - right - 1);
            return right + 1;
        }

        return -1;
    }

    void helper(TreeNode root, int k) {
        if(root == null) {
            return;
        }

        if(k == 0) {
            ans.add(root.val);
            return;
        }

        helper(root.left, k-1);
        helper(root.right, k-1);
    }
}