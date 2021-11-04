/*

Given a binary tree and two node values your task is to find the minimum distance between them.

Example 1:
  Input:
          1
        /  \
       2    3
  a = 2, b = 3
  Output: 2
  Explanation: The tree formed is:
         1
       /   \ 
      2     3
  We need the distance between 2 and 3.
  Being at node 2, we need to take two
  steps ahead in order to reach node 3.
  The path followed will be:
  2 -> 1 -> 3. Hence, the result is 2. 

Your Task:
You don't need to read input or print anything. Your task is to complete the function findDist() which takes the root node of the Tree and the two node values a and b as input parameters and returns the minimum distance between the nodes represented by the two given node values.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
  1 <= Number of nodes <= 10^4
  1 <= Data of a node <= 10^5

*/


class GfG {
    int minDist = -1;
    int findDist(Node root, int a, int b) {
        // Your code here
        if(root == null) {
            return 0;
        }
        
        helper(root, a, b);
        return minDist;
    }   
    
    int helper(Node root, int a, int b) {
        
        if(root == null || minDist > 0) {
            return 0;
        }
        
        int left = helper(root.left, a, b);
        int right = helper(root.right, a, b);
        
        if(root.data == a || root.data == b) {
            if(left != 0) {
                minDist = left;
            } else if(right != 0) {
                minDist = right;
            } else {
                return 1;
            }
        }
        
        if(left != 0 && right != 0) {
            minDist = left + right;
        } else if(left != 0) {
            return left + 1;
        } else if(right != 0){
            return right + 1;
        }
        
        return 0;
    }    
    
}
