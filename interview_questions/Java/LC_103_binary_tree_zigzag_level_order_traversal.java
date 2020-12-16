/*

Given a binary tree, return the zigzag level order traversal of its nodes' values. 
(ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]

*/


class Solution {
    List<List<Integer>> list = new LinkedList<List<Integer>>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        if(root == null) {
            return list;
        }
        
        Stack<TreeNode> current = new Stack<TreeNode>();
        current.add(root);
        
        boolean rightToLeft = false;
        
        while(!current.empty()) {
            Stack<TreeNode> parents = current;
            List<Integer> p = new LinkedList<Integer>();
            current = new Stack<TreeNode>();
            
            while(!parents.empty()) {
                
                TreeNode t = parents.pop();
                
                if(rightToLeft == true) {
                    
                    if(t.right != null) {
                        current.add(t.right);
                    }
                    if(t.left != null) {
                        current.add(t.left);
                    }
                
                } else {
                    
                    if(t.left != null) {
                        current.add(t.left);
                    }
                    if(t.right != null) {
                        current.add(t.right);
                    }
                
                }
                
                p.add(t.val);
            
            }

            list.add(p);
            
            rightToLeft = rightToLeft==true ? false : true;
            
        }
        return list;
        
    }
}