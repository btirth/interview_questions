/*

Given two BSTs containing N1 and N2 distinct nodes respectively and given a value x. Your task is to complete the function countPairs(), that returns the count of all pairs from both the BSTs whose sum is equal to x.


Example 1:
  Input:
  BST1:
         5
       /   \
      3     7
     / \   / \
    2   4 6   8

  BST2:
         10
       /    \
      6      15
     / \    /  \
    3   8  11   18

  x = 16
  Output: 3
  Explanation: The pairs are: (5, 11), (6, 10) and (8, 8)

Example 2:
  Input:
    BST1:
      1
       \
        3
       /
      2
    BST2:
        3
       / \
      2   4
     /     
    1
  x = 4
  Output: 3
  Explanation: The pairs are: (2, 2), (3, 1) and (1, 3)

Your Task:
You don't need to read input or print anything. Your task is to complete the function countPairs(), which takes 2 BST's as parameter in form of root1 and root2 and the integer x, that returns the count of all pairs from both the BSTs whose sum is equal to x.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ Number of nodes ≤ 10^5
1 ≤ Data of a node ≤ 10^6

*/

class Solution
{
    static int count;
   
    static boolean fetch(Node root2,int k){
        if(root2==null) return false;
       
        if(root2.data==k) return true;
       
        boolean x,y;
        x=y=false;
       
        if(root2.data>k){
            x = fetch(root2.left,k);
        } 
       
        if(root2.data<k){
            y=fetch(root2.right,k);
        }
       
        return (x||y);
    }
   
   
    static void solve(Node root1,Node root2,int x){
        if(root1==null){
            return;
        }
        solve(root1.left,root2,x);
       
        if(fetch(root2,x-root1.data)){
            count++;
        }
       
        solve(root1.right,root2,x);
    }
   
    public static int countPairs(Node root1, Node root2, int x) {
        count=0;
        solve(root1,root2,x);
        return count;
    }

}
