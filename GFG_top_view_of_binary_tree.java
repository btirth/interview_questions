/*

Given below is a binary tree. The task is to print the top view of binary tree. Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. For the given below tree

         1
      /     \
     2       3
    /  \    /   \
   4    5  6     7

  Top view will be: 4 2 1 3 7
  
Note: Return nodes from leftmost node to rightmost node.

Example 1:
  Input:
        1
     /    \
    2      3
  Output: 2 1 3
  
Example 2:
  Input:
         10
      /      \
    20        30
   /   \    /    \
  40   60  90    100
  Output: 40 20 10 30 100

Your Task:
  Since this is a function problem. You don't have to take input. Just complete the function topView() that takes root node as parameter and returns a list of nodes visible from the top view from left to right.
  Print endline after end of printing the top view.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N).

Constraints:
  1 ≤ N ≤ 105
  1 ≤ Node Data ≤ 105
 

Note:The Input/Ouput format and Example given are used for system's internal purpose, and should be used by a user for Expected Output only. As it is a function problem, hence a user should not read any input from stdin/console.
The task is to complete the function specified, and not to write the full code.

*/



class Solution
{
    public static void width(Node root, int hl, int[] minMax) {
        if(root == null) {
            return;
        }
        minMax[0] = Math.min(minMax[0], hl);
        minMax[1] = Math.max(minMax[1], hl);
        width(root.left, hl-1, minMax);
        width(root.right, hl+1, minMax);
    }
    public class vPair {
        Node node;
        int hl;
        
        vPair(Node node, int hl) {
            this.node =node;
            this.hl = hl;
        }
    }
    public ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null) {
            return ans;
        }
        
        int[] minMax = new int[2];
        width(root, 0, minMax);
        int len = minMax[1] + Math.abs(minMax[0]) + 1;
        for(int i=0; i<len; i++) {
            ans.add(0);
        }
        
        LinkedList<vPair> q = new LinkedList<>();
        q.addLast(new vPair(root, Math.abs(minMax[0])));
        while(q.size() != 0) {
            int size = q.size();
            while(size-- > 0) {
                vPair rp = q.pollFirst();
                Node node = rp.node;
                int hl = rp.hl;
                
                if(ans.get(hl) == 0) {
                    ans.set(hl, node.data);
                }
                if(node.left != null) {
                    q.addLast(new vPair(node.left, hl-1));    
                }
                if(node.right != null) {
                    q.addLast(new vPair(node.right, hl+1));
                }
            }
        }
        return ans;
    }
}
