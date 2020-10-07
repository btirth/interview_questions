/*

Given an n-ary tree, return the preorder traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value

*/
class Solution {
    List<Integer> nodes = new ArrayList<Integer>();
    
    public List<Integer> preorder(Node root) {
        getPreorder(root);
        return nodes;
    }
    
    void getPreorder(Node root) {
        if(root==null) {
            return;
        }
        nodes.add(root.val);
        for(Node child : root.children) {
            getPreorder(child);
        }
    }
}