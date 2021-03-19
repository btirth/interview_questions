/*

Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

Example 1:
    Input: head = [1,2,3,4,5], left = 2, right = 4
    Output: [1,4,3,2,5]

Example 2:
    Input: head = [5], left = 1, right = 1
    Output: [5]
 
Constraints:
    The number of nodes in the list is n.
    1 <= n <= 500
    -500 <= Node.val <= 500
    1 <= left <= right <= n

*/



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode node = new ListNode();
        node.next = head;
        ListNode prev = node;
        ListNode next = null;
        
        int i=1;
        while(i < left) {
            i++;
            prev = head;
            head = head.next;
        }
        ListNode leftNode = head;
        
        while(i<right) {
            i++;
            head = head.next;
        }
        next = head.next;
        head.next = null;
        
        prev.next = reverseLinkedList(leftNode);
        while(prev.next != null) {
            prev = prev.next;
        }
        prev.next = next;
        
        return node.next;
    }
    
    ListNode reverseLinkedList(ListNode node) {
        ListNode head = null;
        while(node != null) {
            ListNode n = new ListNode(node.val);
            n.next = head;
            head = n;
            node = node.next;
        }
        
        return head;
    }
}