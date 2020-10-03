/*

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:
    Given the sorted array: [-10,-3,0,5,9],
    One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
      0
     / \
   -3   9
   /   /
 -10  5

*/

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        return BST(nums, 0, nums.length-1);
    }
    
    TreeNode BST(int[] nums, int start, int last) {
        if(start==last) return new TreeNode(nums[start]);
        int mid = ((start+last)/2) + ((start+last)%2);
        TreeNode root = new TreeNode(nums[mid]);
        if(mid-1>=start) {
            root.left = BST(nums, start, mid-1);    
        } 
        if(mid+1<=last) {
            root.right = BST(nums, mid+1, last);    
        }
        return root;
    }
}