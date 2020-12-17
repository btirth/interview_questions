/*

One way to serialize a binary tree is to use pre-order traversal. 
When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.

     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #
For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.

Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. 
Find an algorithm without reconstructing the tree.

Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".


Example 1:
    Input: "9,3,4,#,#,1,#,#,2,#,6,#,#"
    Output: true

Example 2:
    Input: "1,#"
    Output: false

Example 3:
    Input: "9,#,#,1"
    Output: falseOne way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.

     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #
For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.

Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.

Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".

Example 1:
    Input: "9,3,4,#,#,1,#,#,2,#,6,#,#"
    Output: true

Example 2:
    Input: "1,#"
    Output: false

Example 3:
    Input: "9,#,#,1"
    Output: false

*/



/* 

Logic:
- Every node will has two values either node or null
- So per node we will add j += 2 
- if it's first node then we need to 2 (j += 2) 
- as we have new node we will remove 1 node (j--) and will add two children of that node (j += 2) so at the and we will do j++;
- for null if  there is no node(j<=0) then return false
- else if there is node (j>0) then remove one because null is children of some node so j--


*/

class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] str = preorder.split(",");
        if(str.length == 1 && str[0].equals("#")) {
            return true;
        }
       
        int j = 0;
        for(int i=0; i<str.length; i++) {
            if(!str[i].equals("#")) {
                if(i==0) {
                    j += 2;
                } else {
                    if(j > 0) {
                        j++;
                    } else {
                        return false;
                    }
                }
            } else {
                if(j > 0) {
                    j--;
                } else {
                    return false;
                }
            }
        }
        
        return j == 0;
    }
}