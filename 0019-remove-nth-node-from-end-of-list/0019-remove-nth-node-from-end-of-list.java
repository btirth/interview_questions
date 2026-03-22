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
        int startFrom = len - n;

        ListNode temp = new ListNode(0);
        ListNode tempHead = temp;
        tempHead.next = head;

        int curr = 0;

        while(curr < startFrom) {
            tempHead = tempHead.next;
            curr++;
        }

        tempHead.next = tempHead.next.next;

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