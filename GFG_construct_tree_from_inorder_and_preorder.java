/*

Given 2 Arrays of Inorder and preorder traversal. Construct a tree and print the Postorder traversal. 

Example 1:
  Input:
    N = 4
    inorder[] = {1 6 8 7}
    preorder[] = {1 6 7 8}
  Output: 8 7 6 1

Example 2:
  Input:
    N = 6
    inorder[] = {3 1 4 0 5 2}
    preorder[] = {0 1 3 4 2 5}
  Output: 3 4 1 5 2 0
  Explanation: The tree will look like
           0
        /     \
       1       2
     /   \    /
    3    4   5

Your Task:
Your task is to complete the function buildTree() which takes 3 arguments(inorder traversal array, preorder traversal array, and size of tree n) and returns the root node to the tree constructed. You are not required to print anything and a new line is added automatically (The post order of the returned tree is printed by the driver's code.)

Expected Time Complexity: O(N*N).
Expected Auxiliary Space: O(N).

Constraints:
1<=Number of Nodes<=1000

*/


class Solution
{
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        // code here 
        return buildTree(inorder, preorder, 0, inorder.length-1, 0, preorder.length-1);
    }
    
    public static Node buildTree(int inorder[], int preorder[], int inS, int inE, int preS, int preE) {
        if(inS > inE) {
            return null;
        }
        
        Node root = new Node(preorder[preS]);
        
        int rootIndex = -1;
        for(int i=inS; i<=inE; i++) {
            if(inorder[i] == root.data) {
                rootIndex = i;
                break;
            }
        }
        
        int lInS = inS;
        int lInE = rootIndex-1;
        int lPreS = preS+1;
        int lPreE = (lInE - lInS) + lPreS;
        
        int rInS = rootIndex+1;
        int rInE = inE;
        int rPreS = lPreE+1;
        int rPreE = preE;
        
        root.left = buildTree(inorder, preorder, lInS, lInE, lPreS, lPreE);
        root.right = buildTree(inorder, preorder, rInS, rInE, rPreS, rPreE);
        return root;
    }
}
