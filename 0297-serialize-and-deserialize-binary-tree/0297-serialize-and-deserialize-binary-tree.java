/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "";
        }

        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder("");
        res.append(root.val+",");
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();

            if(node.left != null) {
                res.append(node.left.val+",");
                q.add(node.left);
            } else {
                res.append("#,");
            }

            if(node.right != null) {
                res.append(node.right.val+",");
                q.add(node.right);
            } else {
                res.append("#,");
            }
        }

        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) {
            return null;
        }

        String[] nodes = data.split(",");

        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
        TreeNode temp = root;
        int idx = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(idx < nodes.length) {
            TreeNode curr = q.poll();

            if(!nodes[idx].equals("#")) {
                curr.left = new TreeNode(Integer.valueOf(nodes[idx]));
                q.add(curr.left);
                
            }
            idx++;
            
            if(!nodes[idx].equals("#")) {
                curr.right = new TreeNode(Integer.valueOf(nodes[idx]));
                q.add(curr.right);
                
            }
            idx++;
        }

        return temp;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));