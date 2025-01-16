/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
[5,4,7,3,null,2,null,-1,null,9]


start = 0;
end = 9;

root = num[start];

left = start + 1
end = 


1 -> 1, 2
2 -> 3, 4, 5, 6



 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String serialized = "";

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node == null) {
                serialized = serialized + ",null";
            } else {
                if(serialized.equals("")) {
                    serialized = ""+node.val;
                } else {
                    serialized = serialized + "," + node.val;
                }
                
                q.add(node.left);
                q.add(node.right);
            }
        }

        System.out.println(serialized);
        return "[" + serialized + "]";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String mainData = data.substring(1, data.length() - 1);
        String[] values = mainData.split(",");

        if(values.length == 0 || values[0].equals("")) {
            return null;
        }

        int rootVal = Integer.valueOf(values[0]);
        TreeNode root = new TreeNode(rootVal);
        TreeNode temp = root;
        int idx = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty() && idx < values.length) {
            int size = q.size();
            while(size-- > 0) {
                TreeNode node = q.poll();
                if(!values[idx].equals("null")) {
                    TreeNode left = new TreeNode(Integer.valueOf(values[idx]));
                    node.left = left;
                    q.add(left);
                }
                idx++;
                if(!values[idx].equals("null")) {
                    TreeNode right = new TreeNode(Integer.valueOf(values[idx]));
                    node.right = right;
                    q.add(right);
                }
                idx++;
            }
        }

        return temp;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));