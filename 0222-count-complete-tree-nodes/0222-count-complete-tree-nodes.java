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
    public int countNodes(TreeNode root) {
        /**
        Can we use property of Complete tree?

        If we know number of levels except last
        num. of nodes = for l in levels-1 : [ans += 2 ^ (l)]

        If I can get last node in last level
        ans += 2 ^ lastLevel - ()
        
         */

        if(root == null) {
            return 0;
        } 
        
        helper(root, 1);
        return (int)(Math.pow(2, levels - 1)) - 1 + leafNodes;
    }

    int levels = 0;
    int leafNodes = 0;

    void helper(TreeNode root, int level) {
        if(root == null) {
            return;
        }

        if(level > levels) {
            leafNodes = 0;
            levels = level;
        }

        if(level == levels) {
            leafNodes++;
        }

        if(root.left != null) {
            helper(root.left, level + 1);
        }

        if(root.right != null) {
            helper(root.right, level + 1);
        }
    }
}