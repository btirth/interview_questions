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
    HashMap<Integer, TreeNode> parentMap;
    TreeNode node;

    public int amountOfTime(TreeNode root, int start) {
        parentMap = new HashMap<>();
        mapParents(root, null);
        getStartNode(root, start);
        return farthestDist(node, 0) - 1;
    }

    int farthestDist(TreeNode node, int prev) {
        if(node == null) {
            return 0;
        }
        
        int maxDepth = 0;
        TreeNode parent = parentMap.get(node.val);
        if(parent != null && parent.val != prev) 
            maxDepth = Math.max(maxDepth, farthestDist(parent, node.val));
        if(node.left != null && node.left.val != prev)
            maxDepth = Math.max(maxDepth, farthestDist(node.left, node.val));
        if(node.right != null && node.right.val != prev)
            maxDepth = Math.max(maxDepth, farthestDist(node.right, node.val));
        return maxDepth+1;
    }

    void getStartNode(TreeNode root, int start) {
        if(root == null || node != null) {
            return;
        }

        if(root.val == start) {
            node = root;
            return;
        }

        getStartNode(root.left, start);
        getStartNode(root.right, start);
    }

    void mapParents(TreeNode root, TreeNode prev) {
        if(root == null) {
            return;
        }
        
        parentMap.put(root.val, prev);
        
        mapParents(root.left, root);
        mapParents(root.right, root);
    } 
}