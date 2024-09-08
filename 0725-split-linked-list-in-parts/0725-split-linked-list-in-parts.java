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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = getLen(head);
        ListNode[] parts = new ListNode[k];
        int remainingNodes = length%k;
        int sameNodes = length/k;

        for(int i=0; i<k; i++) {
            ListNode curr = new ListNode();
            ListNode part = curr;

            for(int j=0; j<sameNodes; j++) {
                curr.next = head;
                curr = curr.next;
                head = head.next;
            }

            if(remainingNodes > 0 && head != null) {
                curr.next = head;
                curr = curr.next;
                head = head.next;
                remainingNodes--;
            }

            curr.next = null;
            parts[i] = part.next;
        }

        return parts;
    }

    int getLen(ListNode head) {
        int len = 0;

        while(head != null) {
            head = head.next;
            len++;
        }

        return len;
    }
}