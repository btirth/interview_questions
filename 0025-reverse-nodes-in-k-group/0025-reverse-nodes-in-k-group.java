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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        ListNode temp = new ListNode();
        ListNode newHead = temp;
        int count = 0;
        while(head != null) {
            count++;
            if(count == k) {
                ListNode tempHead = head.next;
                head.next = null;
                ListNode reversedList = reverse(curr);
                newHead.next = reversedList;
                while(newHead.next != null) {
                    newHead = newHead.next;
                }
                head = tempHead;
                curr = head;
                count = 0;
            } else {
                head = head.next;
            }
        }

        newHead.next = curr;
        return temp.next;
    }

    ListNode reverse(ListNode head) {
        ListNode reversedList = null;

        while(head != null) {
            ListNode temp = head.next;
            head.next = reversedList;
            reversedList = head;
            head = temp;
        }

        return reversedList;
    }
}