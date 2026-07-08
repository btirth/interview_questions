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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode temp = new ListNode(0);
        ListNode tempHead = temp;

        while(l1 != null || l2 != null || carry != 0) {
            int val = carry;
            carry = 0;

            if(l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }

            if(l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }

            carry = val / 10;
            val %= 10;

            tempHead.next = new ListNode(val);
            tempHead = tempHead.next;
        }

        return temp.next;
    }
}