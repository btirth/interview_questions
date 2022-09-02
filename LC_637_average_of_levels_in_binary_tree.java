/*

Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.
 
Example 1:
  Input: root = [3,9,20,null,null,15,7]
  Output: [3.00000,14.50000,11.00000]
  Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].

Example 2:
  Input: root = [3,9,20,15,7]
  Output: [3.00000,14.50000,11.00000]
 
Constraints:
  The number of nodes in the tree is in the range [1, 10^4].
  -2^31 <= Node.val <= 2^31 - 1

*/

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            long sum = 0;
            int qSize = size;
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
            
            ans.add((double)sum/qSize);
        }
        
        return ans;
    }
}
