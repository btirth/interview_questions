/*

Given a Binary Tree, find Right view of it. Right view of a Binary Tree is set of nodes visible when tree is viewed from right side.

Right view of following tree is 1 3 7 8.

          1
       /     \
     2        3
   /   \      /    \
  4     5   6    7
    \
     8

Example 1:
Input:
       1
    /    \
   3      2
Output: 1 2

Example 2:
Input:
     10
    /   \
  20     30
 /   \
40  60 
Output: 10 30 60

Your Task:
Just complete the function rightView() that takes node as parameter and returns the right view as a list. 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 ≤ Number of nodes ≤ 10^5
1 ≤ Data of a node ≤ 10^5

*/




class Solution{
    //Function to return list containing elements of right view of binary tree.
    ArrayList<Integer> rightView(Node node) {
        //add code here.
        int l = getHeight(node);
      ArrayList<Integer> ans = new ArrayList<>();
      
      if(l == 0) {
          return ans;
      }
      ans.add(node.data);
      for(int i=1; i<l; i++) {
          ans.add(0);
      }
      
      Queue<Node> q = new LinkedList<Node>();
      q.add(node);
      
      int idx = 0;
      while(!q.isEmpty()) {
          int size = q.size();
          
          while(size > 0) {
              Node n = q.poll();
              ans.set(idx, n.data);
              if(n.left != null) {
                  q.add(n.left);
              }
              
              if(n.right != null) {
                  q.add(n.right);
              }
              
              size--;
          }
          idx++;
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

