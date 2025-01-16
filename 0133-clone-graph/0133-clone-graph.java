/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Integer, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        Node root;
        if(!map.containsKey(node.val)) {
            Node newNode = new Node(node.val);
            map.put(node.val, newNode);
        } else {
            return map.get(node.val);
        }

        root = map.get(node.val);
        List<Node> neighbors = new ArrayList<>();
        for(Node nei: node.neighbors) {
            neighbors.add(cloneGraph(nei));
        }

        root.neighbors = neighbors;
        return root;
    }
}