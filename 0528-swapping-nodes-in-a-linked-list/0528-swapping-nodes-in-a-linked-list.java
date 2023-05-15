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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode tempH = head;

        ListNode left = head;
        ListNode right = head;
        int len = getLen(head);

        for(int i=0; i<len-k; i++) {
            right = right.next;
        }

        for(int i=0; i<k-1; i++) {
            left = left.next;
        }

        int temp = left.val;
        left.val = right.val;
        right.val = temp;

        return tempH;
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