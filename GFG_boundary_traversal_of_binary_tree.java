/*

Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following order: 

Left boundary nodes: defined as the path from the root to the left-most node ie- the leaf node you could reach when you always travel preferring the left subtree over the right subtree. 
Leaf nodes: All the leaf nodes except for the ones that are part of left or right boundary.
Reverse right boundary nodes: defined as the path from the right-most node to the root. The right-most node is the leaf node you could reach when you always travel preferring the right subtree over the left subtree. Exclude the root from this as it was already included in the traversal of left boundary nodes.
Note: If the root doesn't have a left subtree or right subtree, then the root itself is the left or right boundary. 

Example 1:
  Input:
          1 
        /   \
       2     3  
      / \   / \ 
     4   5 6   7
        / \
       8   9

  Output: 1 2 4 8 9 6 7 3

Example 2:
  Input:
              1
             / 
            2
          /  \
         4    9
       /  \    \
      6    5    3
               /  \
              7     8

  Output: 1 2 4 6 5 7 8
  Explanation: As you can see we have not taken right subtree. See Note

Your Task:
This is a function problem. You don't have to take input. Just complete the function boundary() that takes the root node as input and returns an array containing the boundary values in anti-clockwise.

Expected Time Complexity: O(N). 
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 ≤ Number of nodes ≤ 10^5
1 ≤ Data of a node ≤ 10^5

*/


class Solution
{
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> ans = new ArrayList<>();
	    ans.add(node.data);
	    addLeftBoundary(node, ans);
	    addLeaves(node, ans);
	    addRightBoundary(node, ans);
	    
	    return ans;
	}
	
	void addLeftBoundary(Node root, ArrayList<Integer> ans) {
	    Node cur = root.left;
	    
	    while(cur != null) {
	        if(!isLeaf(cur)) {
	            ans.add(cur.data);
	        }
	        
	        if(cur.left != null) {
	            cur = cur.left;
	        } else {
	            cur = cur.right;
	        }
	    }
	}
	
	void addRightBoundary(Node root, ArrayList<Integer> ans) {
	    Node cur = root.right;
	    Stack<Integer> st = new Stack<>();
	    
	    while(cur != null) {
	        if(!isLeaf(cur)) {
	            st.push(cur.data);
	        }
	        
	        if(cur.right != null) {
	            cur = cur.right;
	        } else {
	            cur = cur.left;
	        }
	    }
	    
	    while(!st.isEmpty()) {
	        ans.add(st.pop());
	    }
	}
	
	void addLeaves(Node root, ArrayList<Integer> ans) {
	    if(root == null) {
	        return;
	    }
	    
	    if(isLeaf(root)) {
	        ans.add(root.data);
	        return;
	    }
	    
	    if(root.left != null) {
	        addLeaves(root.left, ans);
	    }
	    
	    if(root.right != null) {
	        addLeaves(root.right, ans);
	    }
	}
	
	boolean isLeaf(Node root) {
	    if(root.left == null && root.right == null) {
	        return true;
	    }
	    
	    return false;
	}
}
