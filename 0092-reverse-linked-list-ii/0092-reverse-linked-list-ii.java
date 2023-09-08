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