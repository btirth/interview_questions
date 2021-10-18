/*

Given an array arr[] of N nodes representing preorder traversal of BST. The task is to print its postorder traversal.

Example 1:
  Input:
  N = 5
  arr[]  = {40,30,35,80,100}
  Output: 35 30 100 80 40
  Explanation: PreOrder: 40 30 35 80 100
  InOrder: 30 35 40 80 100
  Therefore, the BST will be:
                40
             /      \
           30       80
             \        \   
             35      100
  Hence, the postOrder traversal will be: 35 30 100 80 40

Example 2:
  Input:
  N = 8
  arr[]  = {40,30,32,35,80,90,100,120}
  Output: 35 32 30 120 100 90 80 40

Your Task:
  You need to complete the given function and return the root of the tree. The driver code will then use this root to print the post order traversal.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
  1 <= N <= 10^3
  1 <= arr[i] <= 10^4

*/



public static Node post_order(int pre[], int size) 
{
    postOrder(0, size-1, pre);
    return null;
} 

static void postOrder(int start, int end, int[] pre) {
    if(start > end) {
        return;
    }
    
    int mid = nextGreater(pre, start, end);
    
    postOrder(start+1, mid-1, pre);
    postOrder(mid, end, pre);
    System.out.print(pre[start]+" ");
}

static int nextGreater(int[] pre, int start, int end) {
    int i=start;    
    for(; i<=end; i++) {
        if(pre[i] > pre[start]) {
            break;
        }
    }
    
    return i;
}
