/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]

*/



//Method 1
class Solution {
    int d = 0;
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        d = depth(root);
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(root==null) {
            return lists;
        }
        createLevelList(root, lists, 0);
        return lists;
    }
    
    void createLevelList(TreeNode root, List<List<Integer>> lists, int levels) {
        if(root == null) return;
        
        List<Integer> list = null;
        int l_size = lists.size();
        if(l_size == levels) {
            list = new ArrayList<Integer>();
            lists.add(0, list);
        } else {
            list = lists.get(l_size - levels - 1);
        }
        list.add(root.val);
        createLevelList(root.left, lists, levels+1);
        createLevelList(root.right, lists, levels+1);
        
    }
    
    int depth(TreeNode root) {
        
        if(root==null) {
            return 0;
        }
        int ls = depth(root.left);
        int rs = depth(root.right);
        
        return (Math.max(ls, rs)+1);
    }
}



//Method 2

class Solution {
    int d = 0;
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        d = depth(root);
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(root==null) {
            return lists;
        }
        for(int i=0; i<d; i++) {
            List<Integer> list = new ArrayList<Integer>();
            lists.add(list);
        }
        createLevelList(root, lists, 0);
        return lists;
    }
    
    void createLevelList(TreeNode root, List<List<Integer>> lists, int levels) {
        if(root == null) return;
        
        List<Integer> list = lists.get(d-levels-1);
        list.add(root.val);
        if(root.left != null) 
            createLevelList(root.left, lists, levels+1);
        if(root.right != null)
            createLevelList(root.right, lists, levels+1);
        
    }
    
    int depth(TreeNode root) {
        
        if(root==null) {
            return 0;
        }
        int ls = depth(root.left);
        int rs = depth(root.right);
        
        return (Math.max(ls, rs)+1);
    }
}