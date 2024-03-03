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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = getLen(head);
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode temp = node;

        int k = (len-n);
        for(int i=0; i<k; i++) {
            node = node.next;
        }

        node.next = node.next.next;
        return temp.next;
    }

    int getLen(ListNode node) {
        int len = 0;
        while(node != null) {
            node = node.next;
            len++;
        }

        return len;
    }
}