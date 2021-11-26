/*

Given a singly linked list, remove all the nodes which have a greater value on its following nodes.

Example 1:
  Input: LinkedList = 12->15->10->11->5->6->2->3
  Output: 15 11 6 3
  Explanation: Since, 12, 10, 5 and 2 are the elements which have greater elements on the following nodes. So, after deleting them, the linked list would like be 15, 11, 6, 3.

Example 2:
  Input: LinkedList = 10->20->30->40->50->60
  Output: 60

Your Task:
The task is to complete the function compute() which should modify the list as required and return the head of the modified linked list. The printing is done by the driver code,

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ size of linked list ≤ 1000
1 ≤ element of linked list ≤ 1000

Note: Try to solve the problem without using any extra space.

*/


class Solution
{
    Node compute(Node head)
    {
        // your code here
        if(head == null) {
            return head;
        }
        
        head = reverseList(head);
        Node curr = head;
        Node prev = head;
        int maxVal = head.data;
        head = head.next;
        while(head != null) {
            if(head.data >= maxVal) {
                maxVal = head.data;
                prev = head;
                head = head.next;
            } else {
                prev.next = head.next;
                head = prev.next;
            }
        }
        
        head = reverseList(curr);
        return head;
    }
    
    Node reverseList(Node head) {
        Node prev = null;
        while(head != null) {
            Node temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        
        return prev;
    }
}
