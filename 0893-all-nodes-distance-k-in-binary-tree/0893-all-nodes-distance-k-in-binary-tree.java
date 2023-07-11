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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<TreeNode> path = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        rootToNodePath( root, target, path);
        for(int i = 0; i < path.size(); i++)
        {
            kLevelDown( ans, k-i, path.get(i), (i==0)? null : path.get(i-1));
        }
        return ans;
    }
    boolean rootToNodePath(TreeNode node,TreeNode target, List<TreeNode> path)
    {
        if( node == null) return false;
        if( node == target){
            path.add(target);
            return true;
        }

        if( rootToNodePath( node.left, target, path) || rootToNodePath(node.right, target, path))
        {
            path.add( node);
            return true;
        }
        return false;
    }
    void kLevelDown( List<Integer> ans , int dist, TreeNode node, TreeNode blocker)
    {
        if( node == blocker || node == null ) return ;

        if( dist == 0){
            ans.add( node.val);
            return ;
        }

        kLevelDown(ans, dist-1, node.left, blocker);
        kLevelDown(ans, dist-1, node.right, blocker);
    }
}