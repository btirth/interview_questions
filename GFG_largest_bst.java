/*

Given a binary tree. Find the size of its largest subtree that is a Binary Search Tree.
Note: Here Size is equal to the number of nodes in the subtree.

Example 1:
  Input:
          1
        /   \
       4     4
     /   \
    6     8
  Output: 1
  Explanation: There's no sub-tree with size greater than 1 which forms a BST. All the leaf Nodes are the BSTs with size equal to 1.

Example 2:
  Input: 6 6 3 N 2 9 3 N 8 8 2
              6
          /       \
         6         3
          \      /   \
           2    9     3
            \  /  \
            8 8    2 
  Output: 2
  Explanation: The following sub-tree is a
  BST of size 2: 
         2
      /    \ 
     N      8
   
Your Task:
You don't need to read input or print anything. Your task is to complete the function largestBst() that takes the root node of the Binary Tree as its input and returns the size of the largest subtree which is also the BST. If the complete Binary Tree is a BST, return the size of the complete Binary Tree. 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the BST).

Constraints:
1 ≤ Number of nodes ≤ 10^5
1 ≤ Data of a node ≤ 10^6

*/


class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    public static class BSTPair {
        boolean isBST;
        int min;
        int max;
        int size;
    } 
    
    static int largestBst(Node root)
    {
        // Write your code here
        return largestBST(root).size;
    }
    
    public static BSTPair largestBST(Node node) {
        if(node == null) {
            BSTPair bp = new BSTPair();
            bp.isBST = true;
            bp.min = Integer.MAX_VALUE;
            bp.max = Integer.MIN_VALUE;
            bp.size = 0;
            
            return bp;
        }
        
        BSTPair left = largestBST(node.left);
        BSTPair right = largestBST(node.right);
        
        BSTPair bp = new BSTPair();
        bp.isBST = left.isBST && right.isBST && (node.data > left.max && node.data < right.min);
        bp.max = Math.max(node.data, Math.max(left.max, right.max));
        bp.min = Math.min(node.data, Math.min(left.min, right.min));
        
        if(bp.isBST) {
            bp.size = left.size + right.size + 1;
        } else if(left.size > right.size) {
            bp.size = left.size;
        } else {
            bp.size = right.size;
        }
        
        return bp;
    }
    
}
