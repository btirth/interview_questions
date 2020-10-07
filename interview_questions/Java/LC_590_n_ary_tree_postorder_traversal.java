/*

Given an n-ary tree, return the postorder traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value

*/

class Solution {
    List<Integer> nodes = new ArrayList<Integer>();
    public List<Integer> postorder(Node root) {
        getPostorder(root);
        return nodes;
    }
    
    void getPostorder(Node root) {
        if(root==null) {
            return;
        }
        
        for(Node child : root.children) {
            getPostorder(child);
        }
        
        nodes.add(root.val);
    }
}