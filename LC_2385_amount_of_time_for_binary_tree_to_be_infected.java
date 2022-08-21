/*

You are given the root of a binary tree with unique values, and an integer start. At minute 0, an infection starts from the node with value start.

Each minute, a node becomes infected if:
  The node is currently uninfected.
  The node is adjacent to an infected node.
  Return the number of minutes needed for the entire tree to be infected.

Example 1:
  Input: root = [1,5,3,null,4,10,6,9,2], start = 3
  Output: 4
  Explanation: The following nodes are infected during:
    - Minute 0: Node 3
    - Minute 1: Nodes 1, 10 and 6
    - Minute 2: Node 5
    - Minute 3: Node 4
    - Minute 4: Nodes 9 and 2
    It takes 4 minutes for the whole tree to be infected so we return 4.

Example 2:
  Input: root = [1], start = 1
  Output: 0
  Explanation: At minute 0, the only node in the tree is infected so we return 0.

Constraints:
  The number of nodes in the tree is in the range [1, 10^5].
  1 <= Node.val <= 10^5
  Each node has a unique value.
  A node with a value of start exists in the tree.

*/


class Solution {
    HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
    TreeNode startNode = null;
    public int amountOfTime(TreeNode root, int start) {
        int minutes = 0;
        parentMap.put(root, null);
        mapParent(root, start);
        Queue<TreeNode> infected = new LinkedList<>();
        infected.add(startNode);
        startNode.val = -1;
        while(!infected.isEmpty()) {
            int size = infected.size();
            while(size-- > 0) {
                TreeNode node = infected.poll();
                
                if(node.left != null && node.left.val != -1) {
                    infected.add(node.left);
                    node.left.val = -1;
                }
                
                if(node.right != null && node.right.val != -1) {
                    infected.add(node.right);
                    node.right.val = -1;
                }
                
                TreeNode parent = parentMap.get(node);
                if(parent!=null && parent.val != -1) {
                    infected.add(parent);
                    parent.val = -1;
                }
            }
            minutes++;
        }
        
        return minutes-1;
    }
    
    void mapParent(TreeNode root, int start) {
        if(root == null) {
            return;
        }
        if(root.val == start) {
            startNode = root;
        }
        if(root.left != null) {
            parentMap.put(root.left, root);
            mapParent(root.left, start);
        }
        
        if(root.right != null) {
            parentMap.put(root.right, root);
            mapParent(root.right, start);
        }
    }
}
