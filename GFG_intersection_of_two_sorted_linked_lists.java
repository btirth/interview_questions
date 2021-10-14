/*

Given two lists sorted in increasing order, create a new list representing the intersection of the two lists. The new list should be made with its own memory — the original lists should not be changed.
Note: The list elements are not necessarily distinct.

Example 1:
Input:
L1 = 1->2->3->4->6
L2 = 2->4->6->8
Output: 2 4 6
Explanation: For the given first two
linked list, 2, 4 and 6 are the elements
in the intersection.

Example 2:
Input:
L1 = 10->20->40->50
L2 = 15->40
Output: 40

Your Task:
The task is to complete the function intersection() which should find the intersection of two linked list and add all the elements in intersection to the third linked list and return the head of the third linked list.

Expected Time Complexity : O(n+m)
Expected Auxilliary Space : O(n+m)
Note: n,m are the size of the linked lists.

Constraints:
1 <= size of linked lists <= 5000
1 <= Data in linked list nodes <= 1000

*/



class Sol
{
   public static Node findIntersection(Node head1, Node head2)
    {
        // code here.
        Node newNode = new Node(0);
        Node head = newNode;
        
        while(head1 != null && head2 != null) {
            if(head1.data == head2.data) {
                head.next = new Node(head1.data);
                head = head.next;
                head1 = head1.next;
                head2 = head2.next;
            } else if(head1.data > head2.data) {
                head2 = head2.next;
            } else {
                head1 = head1.next;
            }
        }
        
        return newNode.next;
    }
}
