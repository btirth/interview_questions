/*

Sort the given Linked List using quicksort. which takes O(n^2) time in worst case and O(nLogn) in average and best cases, otherwise you may get TLE.

Input:
In this problem, method takes 1 argument: address of the head of the linked list. The function should not read any input from stdin/console.
The struct Node has a data part which stores the data and a next pointer which points to the next element of the linked list.
There are multiple test cases. For each test case, this method will be called individually.

Output:
Set *headRef to head of resultant linked list.

User Task:
The task is to complete the function quickSort() which should set the *headRef to head of the resultant linked list.

Constraints:
1<=T<=100
1<=N<=200

Note: If you use "Test" or "Expected Output Button" use below example format

Example:
  Input:
    2
    3
    1 6 2
    4
    1 9 3 8
  Output:
    1 2 6
    1 3 8 9
  Explanation:
    Testcase 1: After sorting the nodes, we have 1, 2 and 6.
    Testcase 2: After sorting the nodes, we have 1, 3, 8 and 9.

*/


class GfG
{
    public static Node quickSort(Node node)
    {
        //Your code here
        Node headRef = quickSort_(node)[0];
        return headRef;
    }
    
    public static Node[] quickSort_(Node node) {
        if(node == null || node.next == null) {
            return new Node[] {node, node};
        }
        
        int len = length(node);
        int pivotIdx = len / 2;
        
        Node[] segregatedLists = segregate(node, pivotIdx);
        
        Node[] leftSortedList = quickSort_(segregatedLists[0]);
        Node[] rightSortedList = quickSort_(segregatedLists[2]);
        
        return mergeSortedLists(leftSortedList, segregatedLists[1], rightSortedList);
    }
    
    public static int length(Node node) {
        if(node == null) {
            return 0;
        }
        
        int len = 0;
        while(node != null) {
            node = node.next;
            len++;
        }
        
        return len;
    }
    
    public static Node[] mergeSortedLists(Node[] left, Node pivot, Node[] right) {
        Node head = null;
        Node tail = null;
        
        if(left[0] != null && right[0] != null) {
            left[1].next = pivot;
            pivot.next = right[0];
            head = left[0];
            tail = right[1];
        } else if(left[0] != null) {
            head = left[0];
            left[1].next = pivot;
            tail = pivot;
        } else if(right[0] != null) {
            head = pivot;
            pivot.next = right[0];
            tail = right[1];
        } else {
            head = pivot;
            tail = pivot;
        }
        
        return new Node[]{head, tail};
    }
    
    public static Node[] segregate(Node node, int pivotIdx) {
        Node smallHead = new Node(-1);
        Node largeHead = new Node(-1);
        Node smallTail = smallHead;
        Node largeTail = largeHead;
        
        Node curr = node;
        Node pivot = node;
        
        while(pivotIdx-- > 0) {
            pivot = pivot.next;
        }
        
        while(curr != null) {
            if(curr != pivot) {
                if(curr.data <= pivot.data) {
                    smallTail.next = curr;
                    smallTail = smallTail.next;
                } else {
                    largeTail.next = curr;
                    largeTail = largeTail.next;
                }
            }   
            
            curr = curr.next;
        }
        
        smallTail.next = null;
        largeTail.next = null;
        pivot.next = null;
        
        return new Node[]{smallHead.next, pivot, largeHead.next};
    }
}
