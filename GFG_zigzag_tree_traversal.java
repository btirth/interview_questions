/*

Given a Binary Tree. Find the Zig-Zag Level Order Traversal of the Binary Tree.

Example 1:
Input:
        3
      /   \
     2     1
Output:
3 1 2

Example 2:
Input:
           7
        /     \
       9       7
     /  \     /   
    8    8   6     
   /  \
  10   9 
Output:
7 7 9 8 8 6 9 10 
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function zigZagTraversal() which takes the root node of the Binary Tree as its input and returns a list containing the node values as they appear in the Zig-Zag Level-Order Traversal of the Tree.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 10^4

*/


class GFG
{
	ArrayList<Integer> zigZagTraversal(Node root)
	{
	    ArrayList<Integer> ans = new ArrayList<>();
	    if(root == null) {
	        return ans;
	    }
	    
	    Queue<Node> q = new LinkedList<>();
	    q.add(root);
	    
	    boolean l_r = true;
	    while(!q.isEmpty()) {
	        int size = q.size();
	        int ansSize = ans.size();
	        while(size > 0) {
	            Node n = q.poll();
	            if(l_r) {
	                ans.add(n.data);
	            } else {
	                ans.add(ansSize, n.data);
	            }
	            
	            if(n.left != null) {
	                q.add(n.left);
	            }
	            
	            if(n.right != null) {
	                q.add(n.right);
	            }
	            size--;
	        }
	        
	        l_r = !l_r;
	    }
	    
	    return ans;
	}
}
