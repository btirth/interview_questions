/*

You are given the root of a binary tree. We install cameras on the tree nodes where each camera at a node can monitor its parent, itself, and its immediate children.

Return the minimum number of cameras needed to monitor all nodes of the tree.

Example 1:
  Input: root = [0,0,null,0,0]
  Output: 1
  Explanation: One camera is enough to monitor all nodes if placed as shown.

Example 2:
  Input: root = [0,0,null,0,null,0,null,null,0]
  Output: 2
  Explanation: At least two cameras are needed to monitor all nodes of the tree. The above image shows one of the valid configurations of camera placement.

Constraints:
  The number of nodes in the tree is in the range [1, 1000].
  Node.val == 0

*/

class Solution {
    private int numOfCameras = 0;
    
    public int minCameraCover(TreeNode root) {
        return dfs(root) == -1 ? numOfCameras + 1 : numOfCameras;
    }
    
    // -1: NOT MONITORED
    //  0: MONITORED
    //  1: HAS CAMERA
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        
        int left = dfs(root.left);
        int right = dfs(root.right);
        
        if (left == -1 || right == -1) {
            numOfCameras++;
            return 1; 
        }
        
        if (left == 1 || right == 1)
            return 0; 
        
        return -1;
    }
}
