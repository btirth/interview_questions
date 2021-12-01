/*

Given a BST and an integer K. Find the Kth Smallest element in the BST. 

Example 1:
  Input:
        2
      /   \
     1     3
  K = 2
  Output: 2

Example 2:
  Input:
          2
        /  \
       1    3
  K = 5
  Output: -1
 
Your Task:
You don't need to read input or print anything. Your task is to complete the function KthSmallestElement() which takes the root of the BST and integer K as inputs and return the Kth smallest element in the BST, if no such element exists return -1.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1<=Number of nodes<=100000

*/


class Solution {
    // Return the Kth smallest element in the given BST
    public int KthSmallestElement(Node node, int K) {
        // Write your code here
        Stack<Node> st = new Stack<>();
        int count = 0;
        
        while(true) {
            if(node != null) {
                st.push(node);
                node = node.left;
            } else {
                if(st.empty()) {
                    break;
                }
                node = st.pop();
                count++;
                if(count == K) {
                    return node.data;
                }
                node = node.right;
            }
        }
        
        return -1;
    }
}
