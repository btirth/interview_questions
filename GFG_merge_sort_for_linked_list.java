/*

Given Pointer/Reference to the head of the linked list, the task is to Sort the given linked list using Merge Sort.
Note: If the length of linked list is odd, then the extra node should go in the first list while splitting.

Example 1:
  Input:
    N = 5
    value[]  = {3,5,2,4,1}
  Output: 1 2 3 4 5
  Explanation: After sorting the given linked list, the resultant matrix will be 1->2->3->4->5.

Example 2:
  Input:
    N = 3
    value[]  = {9,15,0}
  Output: 0 9 15
  Explanation: After sorting the given linked list , resultant will be 0->9->15.

Your Task:
For C++ and Python: The task is to complete the function mergeSort() which sort the linked list using merge sort function.
For Java: The task is to complete the function mergeSort() and return the node which can be used to print the sorted linked list.

Expected Time Complexity: O(N*Log(N))
Expected Auxiliary Space: O(N)

Constraints:
1 <= T <= 100
1 <= N <= 10^5

*/


class Solution
{
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
        // add your code here
        Node tail = head;
        while(tail.next != null) {
            tail = tail.next;
        }
        return mergeSort(head, tail);
    }
    
    static Node mergeSort(Node head, Node tail) {
        if(head == tail) {
            return new Node(head.data);
        }
        Node mid = findMid(head, tail);
        Node first = mergeSort(head, mid);
        Node second = mergeSort(mid.next, tail);
        Node sortedList = mergeTwoList(first, second);
        return sortedList;
    } 
    
    static Node findMid(Node head, Node tail) {
        Node slow = head;
        Node fast = head;
        
        while(fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
    
    static Node mergeTwoList(Node first, Node second) {
        if(first == null || second == null) {
            return first == null ? second : first;
        }
        
        Node curr = new Node(-1);
        Node temp = curr;
        while(first != null && second != null) {
            if(first.data < second.data) {
                curr.next = first;
                first = first.next;
            } else {
                curr.next = second;
                second = second.next;
            }
            
            curr = curr.next;
        }
        
        curr.next = first == null ? second : first;
        
        return temp.next;
    }
}
