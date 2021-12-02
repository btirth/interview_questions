/*

Given a Binary Tree, convert it to Binary Search Tree in such a way that keeps the original structure of Binary Tree intact.
 

Example 1:
  Input:
        1
      /   \
     2     3
  Output: 1 2 3

Example 2:
  Input:
            1
         /    \
       2       3
     /        
   4       
  Output: 1 2 3 4
  Explanation:
  The converted BST will be

          3
        /   \
      2     4
    /
   1 

Your Task:
You don't need to read input or print anything. Your task is to complete the function binaryTreeToBST() which takes the root of the Binary tree as input and returns the root of the BST. The driver code will print inorder traversal of the converted BST.

Expected Time Complexity: O(NLogN).
Expected Auxiliary Space: O(N).

Constraints:
1 <= Number of nodes <= 1000

*/


class Solution
{
    // The given root is the root of the Binary Tree
    // Return the root of the generated BST
    List<Integer> list = new ArrayList<>();
    int idx = 0;
    Node binaryTreeToBST(Node root)
    {
       // Your code here
       Node temp = root;
       inorderBT(root);
       Collections.sort(list);
       inorderBST(root);
       return root;
    }
    
    void inorderBT(Node root) {
        if(root == null) {
            return;
        }
        
        if(root.left != null) {
            inorderBT(root.left);
        }
        list.add(root.data);
        if(root.right != null) {
            inorderBT(root.right);
        }
    }
    
    void inorderBST(Node root) {
        if(root == null) {
            return;
        }
        
        if(root.left != null) {
            inorderBST(root.left);
        }
        root.data = list.get(idx);
        idx++;
        if(root.right != null) {
            inorderBST(root.right);
        }
    }
}
