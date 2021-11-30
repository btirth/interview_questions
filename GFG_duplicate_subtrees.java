/*

Given a binary tree of size N, your task is to that find all duplicate subtrees from the given binary tree.

Your Task:
You don't need to take input. Just complete the function printAllDups() that takes the root node as a parameter and returns an array of Node*, which contains all the duplicate subtree.
Note: Here the Output of every Node printed in the Pre-Order tree traversal format.

Constraints:
1<=T<=100
1<=N<=100

*/


class Solution{
    HashMap<String, Node> map = new HashMap<>();
    List<Node> res = new ArrayList<>();
    public List<Node> printAllDups(Node root)
    {
       //code here
       
       solve(root);
       return res;
    }
    
    String solve(Node root) {
        if(root == null) {
            return "$";
        }
        
        StringBuilder sb = new StringBuilder("");
        sb.append(String.valueOf(root.data));
        sb.append("*");
        sb.append(solve(root.left));
        sb.append("*");
        sb.append(solve(root.right));
        
        String s = new String(sb);
        if(map.containsKey(s)) {
            if(!res.contains(map.get(s))) {
                res.add(map.get(s));
            }
        } else {
            map.put(s, root);
        }
        
        return s;
    }
}
