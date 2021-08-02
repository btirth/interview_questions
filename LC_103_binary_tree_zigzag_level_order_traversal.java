/*

Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

Example 1:
  Input: root = [3,9,20,null,null,15,7]
  Output: [[3],[20,9],[15,7]]

Example 2:
  Input: root = [1]
  Output: [[1]]

Example 3:
  Input: root = []
  Output: []
 
Constraints:
  The number of nodes in the tree is in the range [0, 2000].
  -100 <= Node.val <= 100

*/


// Iterative
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean reverse = false;
        while(q.size() != 0) {
            List<Integer> list = new ArrayList<>();
            int size = q.size();
            while(size > 0) {
                TreeNode node = q.poll();
                if(reverse) {
                    list.add(0, node.val);
                } else {
                    list.add(node.val);
                }
                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
                size--;
            }
            reverse = !reverse;
            ans.add(list);
        }
        return ans;
    }
}



// Recursive
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        zigzagLevelOrder(root, ans, 0);
        
        return ans;
    }
    
    void zigzagLevelOrder(TreeNode root, List<List<Integer>> ans, int level) {
        if(root == null) {
            return;
        }
        
        if(ans.size() <= level) {
            List<Integer> list = new ArrayList<>();
            ans.add(list);
        }
        List<Integer> levelList = ans.get(level);
        if(level%2 == 1) {
            levelList.add(0, root.val);
        } else {
            levelList.add(root.val);
        }
        
        if(root.left != null) {
            zigzagLevelOrder(root.left, ans, level+1);
        }
        if(root.right != null) {
            zigzagLevelOrder(root.right, ans, level+1);
        }
    } 
}
