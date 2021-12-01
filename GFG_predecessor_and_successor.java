/*

There is BST given with root node with key part as integer only. You need to find the inorder successor and predecessor of a given key. In case, if the either of predecessor or successor is not found print -1.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains n denoting the number of edges of the BST. The next line contains the edges of the BST. The last line contains the key.

Output:
Print the predecessor followed by successor for the given key. If the predecessor or successor is not found print -1.

Constraints:
  1<=T<=100
  1<=n<=100
  1<=data of node<=100
  1<=key<=100

Example:
  Input:
    2
    6
    50 30 L 30 20 L 30 40 R 50 70 R 70 60 L 70 80 R
    65
    6
    50 30 L 30 20 L 30 40 R 50 70 R 70 60 L 70 80 R
    100
  Output:
    60 70
    80 -1

*/


class GfG
{
    static int inpre=-1;
    static int insucc=-1;
    public static void findPreSuc(Node root, Res p, Res s, int key)
    {
       travers(root,key);
       p.pre=new Node(inpre);
       s.succ=new Node(insucc);
       inpre=-1;
       insucc=-1;
    }
    static void travers(Node node,int key)
    {
        if(node == null) {
            return;
        }
        
        if(node.data < key)
        {
            if(inpre == -1) {
                inpre=node.data;    
            } else {
                inpre=Math.max(node.data,inpre);     
            }
           
        } else if(node.data > key)
        {
            if(insucc == -1) {
                insucc=node.data;    
            } else {
                insucc=Math.min(node.data,insucc);
            }
            
        }
        
         travers(node.left,key);
        travers(node.right,key);
    }
}
