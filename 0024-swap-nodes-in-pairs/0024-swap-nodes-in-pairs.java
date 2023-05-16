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
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode tempHead = newHead;
        
        while(tempHead.next != null && tempHead.next.next != null) {
            ListNode tempNode = tempHead.next;
            tempHead.next = tempHead.next.next;
            tempNode.next = tempHead.next.next;
            tempHead.next.next = tempNode;
            tempHead = tempHead.next.next;
        }

        return newHead.next;
    }
}