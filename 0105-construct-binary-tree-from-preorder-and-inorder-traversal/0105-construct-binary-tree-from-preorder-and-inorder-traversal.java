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


/**
preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
start = 0;
end = n-1;
is = 0;
ie = n-1;

root = preorder[start]
for i in inorder[is - ie]:
    if num at i == preorder[start]
        lie = i-1;
        break;

lis = is;
ris = lie + 1;
rie = ie;
lps = ps + 1
lpe = lps + (lie - lis)
rps = lpe + 1
rpe = pe;        



 */ 
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    TreeNode helper(int[] preorder, int[] inorder, int ps, int pe, int is, int ie) {
        if(ps == pe) {
            return new TreeNode(preorder[ps]);
        }

        if(ps > pe) {
            return null;
        }

       int rootVal = preorder[ps];
       int rootIdx = 0;
       
       for(int i=is; i<=ie; i++) {
            if(inorder[i] == rootVal) {
                rootIdx = i;
                break;
            }
       }

       int lis = is;
       int lie = rootIdx - 1;
       int ris = rootIdx + 1;
       int rie = ie;

       int lps = ps + 1;
       int lpe = lps + (lie - lis);
       int rps = lpe + 1;
       int rpe = pe;

       TreeNode node = new TreeNode(rootVal);
       node.left = helper(preorder, inorder, lps, lpe, lis, lie);
       node.right = helper(preorder, inorder, rps, rpe, ris, rie);

       return node;
    }
}