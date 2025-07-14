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
    public int getDecimalValue(ListNode head) {
        StringBuilder res = new StringBuilder("");

        while(head != null) {
            res.append(head.val);
            head = head.next;
        }

        return Integer.parseInt(res.toString(), 2);
    }
}