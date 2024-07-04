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
    public ListNode mergeNodes(ListNode head) {
        ListNode newList = new ListNode(0);
        ListNode newHead = newList;
        int sum = 0;

        while(head != null) {
            if(head.val == 0 && sum>0) {
                newHead.next = new ListNode(sum);
                sum = 0;
                newHead = newHead.next;
            }

            sum += head.val;
            head = head.next;
        }

        if(sum != 0) {
            newHead.next = new ListNode(sum);
        }

        return newList.next;
    }
}