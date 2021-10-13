/*

Given a Binary Tree, print Left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from Left side. The task is to complete the function leftView(), which accepts root of the tree as argument.

Left view of following tree is 1 2 4 8.

          1
       /     \
     2        3
   /   \    / \
  4    5   6   7
   \
     8   

Example 1:
Input:
   1
 /  \
3    2
Output: 1 3

Example 2:
Input:
Output: 10 20 40
Your Task:
You just have to complete the function leftView() that prints the left view. The newline is automatically appended by the driver code.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
0 <= Number of nodes <= 100
1 <= Data of a node <= 1000

*/



class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      int l = getHeight(root);
      ArrayList<Integer> ans = new ArrayList<>();
      
      if(l == 0) {
          return ans;
      }
      ans.add(root.data);
      for(int i=1; i<l; i++) {
          ans.add(0);
      }
      
      Queue<Node> q = new LinkedList<Node>();
      q.add(root);
      
      int idx = 0;
      while(!q.isEmpty()) {
          int size = q.size();
          ans.set(idx, q.peek().data);
          idx++;
          
          while(size > 0) {
              Node n = q.poll();
              if(n.left != null) {
                  q.add(n.left);
              }
              
              if(n.right != null) {
                  q.add(n.right);
              }
              
              size--;
          }
      }
      return ans;
    }
    
    int getHeight(Node root) {
        if(root == null) {
            return 0;
        }
        
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        
        return Math.max(left, right) + 1;
    }
}
