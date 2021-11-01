/*

Given a Binary Tree, check if all leaves are at same level or not.

  Example 1:
  Input: 
              1
            /   \
           2     3

  Output: 1
  Explanation: 
    Leaves 2 and 3 are at same level.

Example 2:
  Input:
              10
            /    \
          20      30
         /  \        
       10    15

  Output: 0
  Explanation:
    Leaves 10, 15 and 30 are not at same level.

Your Task: 
You dont need to read input or print anything. Complete the function check() which takes root node as input parameter and returns true/false depending on whether all the leaf nodes are at the same level or not.
 
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(height of tree)
 
Constraints:
1 ≤ N ≤ 10^3

*/


class Solution
{
    int maxLevel = -1;
    boolean sameLevel = true;
    boolean check(Node root)
    {
	// Your code here
	    helper(root, 0);
	    return sameLevel;
    }
    
    void helper(Node root, int l) {
        if(root == null) {
            return;
        }
        
        if(!sameLevel) {
            return;
        }
        
        if(root.left == null && root.right == null) {
            if(maxLevel == -1) {
                maxLevel = l;
            } else if(maxLevel != l){
                sameLevel = false;
                return;
            }
            return;
        }
        
        if(root.left != null) {
            helper(root.left, l+1);
        }
        
        if(root.right != null) {
            helper(root.right, l+1);
        }
    }
}
