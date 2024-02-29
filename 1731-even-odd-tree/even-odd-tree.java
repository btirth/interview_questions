/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        boolean evenLevel = true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> val = new ArrayList<>();

            while(size-- > 0) {
                TreeNode node = q.poll();
                val.add(node.val);
                if(node.left != null) {
                    q.add(node.left);
                }

                if(node.right != null) {
                    q.add(node.right);
                }
            }

            if(!verify(val, evenLevel)) {
                return false;
            }

            evenLevel = !evenLevel;
        }

        return true;
    }

    boolean verify(List<Integer> nums, boolean evenLevel) {
        int prev = -1;
        if(evenLevel) {
            for(int i=0; i<nums.size(); i++) {
                int num = nums.get(i);

                if(num%2 == 0 || (prev != -1 && prev >= num)) {
                    return false;
                }

                prev = num;
            }
        } else {
            for(int i=0; i<nums.size(); i++) {
                int num = nums.get(i);

                if(num%2 == 1 || (prev != -1 && prev <= num)) {
                    return false;
                }

                prev = num;
            }
        }

        return true;
    }
}