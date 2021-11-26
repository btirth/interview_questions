/*

Given a linked list of N nodes where nodes can contain values 0s, 1s, and 2s only. The task is to segregate 0s, 1s, and 2s linked list such that all zeros segregate to head side, 2s at the end of the linked list, and 1s in the mid of 0s and 2s.

Example 1:
  Input:
  N = 8
  value[] = {1,2,2,1,2,0,2,2}
  Output: 0 1 1 2 2 2 2 2

Example 2:
  Input:
  N = 4
  value[] = {2,2,0,1}
  Output: 0 1 2 2
  Explanation: After arranging all the 0s,1s and 2s in the given format, the output will be 0 1 2 2.

Your Task:
The task is to complete the function segregate() which segregates the nodes in the linked list as asked in the problem statement and returns the head of the modified linked list. The printing is done automatically by the driver code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 10^3

*/


class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        // add your code here
        int zero = 0;
        int one = 0;
        int two = 0;
        Node tempHead = head;
        Node ans = tempHead;
        while(head != null) {
            if(head.data == 0) {
                zero++;
            } else if(head.data == 1) {
                one++;
            } else {
                two++;
            }
            head = head.next;
        }
        
        while(zero-- > 0) {
            tempHead.data = 0;
            tempHead = tempHead.next;
            
        }
        
        while(one-- > 0) {
            tempHead.data = 1;
            tempHead = tempHead.next;
        }
        while(two-- > 0) {
            tempHead.data = 2;
            tempHead = tempHead.next;
        }
        
        return ans;
    }
}
