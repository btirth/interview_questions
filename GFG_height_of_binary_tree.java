/*

Given a binary tree, find its height.

Example 1:
  Input:
       1
      /  \
     2    3
  Output: 2

Example 2:
  Input:
    2
     \
      1
     /
   3
  Output: 3   

Your Task:
  You don't need to read input or print anything. Your task is to complete the function height() which takes root node of the tree as input parameter and returns an integer denoting the height of the tree. If the tree is empty, return 0. 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
  1 <= Number of nodes <= 10^5
  1 <= Data of a node <= 10^5

*/


class Solution {
    int height(Node node) 
    {
        if(node == null) {
            return 0;
        }
        int h = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(q.size() != 0) {
            int size = q.size();
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
            h++;
        }
        return h;
    }
}
