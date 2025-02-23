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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        /**
        pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
        prs=0, pre=len-1, pos=0, poe=len-1
        root = pos[poe] = 1
        next = post[poe - 1] = 3

        for i in (prs, pre)
            if(pre[i] == next)
                break

        lprs = prs + 1
        lpre = i - 1

        rprs = i
        rpre = pre

        lpos = pos
        lpoe = lpre - lprs + lpos
        rpos = lpoe + 1
        rpoe = poe - 1        


        prs = 0, pre = 6, pos = 0, poe = 6
            root = 1, right = 3
            i = 4
                lprs = 1, lpre = 4-1 = 3, rprs=4, rpre=6
                lpos = 0, lpoe = 3 - 1 + 0 = 2, rpos = 3, rpoe = 5
        
        prs = 1, pre = 3, pos = 0, poe = 2
            root = 2, right = 5
            i = 3
                lprs = 2, lpre = 3 - 1 = 2

        prs = 4, pre = 6, pos = 3, poe = 5
         */
        return helper(preorder, postorder, 0, preorder.length - 1, 0, postorder.length - 1); 
    }

    TreeNode helper(int[] pr, int[] po, int prs, int pre, int pos, int poe) {
        if(prs > pre || pos > poe) {
            return null;
        }

        if(prs == pre || pos == poe) {
            return new TreeNode(pr[prs]);
        }

        int rootVal = pr[prs];
        int next = po[poe - 1];
        int i = prs;
        for(; i<=pre; i++) {
            if(pr[i] == next) {
                break;
            }
        }

        int lprs = prs + 1;
        int lpre = i - 1;
        int rprs = i;
        int rpre = pre;

        int lpos = pos;
        int lpoe = lpre - lprs + lpos;
        int rpos = lpoe + 1;
        int rpoe = poe - 1;
        
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(pr, po, lprs, lpre, lpos, lpoe);
        root.right = helper(pr, po, rprs, rpre, rpos, rpoe);

        return root;
    }
}