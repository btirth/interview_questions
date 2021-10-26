/*

Given a Cirular Linked List of size N, split it into two halves circular lists. If there are odd number of nodes in the given circular linked list then out of the resulting two halved lists, first list should have one node more than the second list. The resultant lists should also be circular lists and not linear lists.

Example 1:
  Input:
  Circular LinkedList: 1->5->7
  Output:
  1 5
  7
 
Example 2:
  Input:
  Circular LinkedList: 2->6->1->5
  Output:
  2 6
  1 5

Your Task:
Your task is to complete the given function splitList(), which takes 3 input parameters: The address of the head of the linked list, addresses of the head of the first and second halved resultant lists and Set the head1_ref and head2_ref to the first resultant list and second resultant list respectively.

Expected Time Complexity: O(N)
Expected Auxilliary Space: O(1)

Constraints:
1 <= N <= 100

*/


class gfg
{
        // Function  to split a circular LinkedList
	void splitList(circular_LinkedList list)
    {
            Node head = list.head;
            Node mid = findMid(head);
            Node last = mid.next;
            while(last.next != head) {
                last = last.next;
            }
            
            list.head2 = mid.next;
            list.head1 = head;
            last.next = mid.next;
            mid.next = head;
	}
	
	Node findMid(Node head) {
	    Node slow = head;
	    Node fast = head;
	    
	    while(fast.next != head && fast.next.next != head) {
	        slow = slow.next;
	        fast = fast.next.next;
	    }
	    
	    return slow;
	}
}
