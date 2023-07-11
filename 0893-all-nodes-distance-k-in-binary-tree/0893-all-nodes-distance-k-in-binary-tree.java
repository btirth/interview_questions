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
    TreeNode[] parent = new TreeNode[501];
    boolean[] visited = new boolean[501];
    TreeNode target;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        this.target = target;
        getParent(root);
        helper(target, k);
        return ans;
    }

    void getParent(TreeNode node) {
        if(node.val == target.val) {
            return;
        }
        if(node.left != null) {
            getParent(node.left);
            parent[node.left.val] = node;
        }

        if(node.right != null) {
            getParent(node.right);
            parent[node.right.val] = node;
        }
    } 

    void helper(TreeNode node, int dist) {
        if(node == null || visited[node.val]) {
            return;
        }

        visited[node.val] = true;

        if(dist == 0) {
            ans.add(node.val);
            return;
        }

        getChildFromK(node.left, dist-1);
        getChildFromK(node.right, dist-1);
        helper(parent[node.val], dist-1);
    }

    void getChildFromK(TreeNode node, int dist) {
        if(node == null) {
            return;
        }

        if(visited[node.val]) {
            return;
        }

        visited[node.val] = true;

        if(dist == 0) {
            ans.add(node.val);
            return;
        }

        getChildFromK(node.left, dist-1);
        getChildFromK(node.right, dist-1);
    }
}