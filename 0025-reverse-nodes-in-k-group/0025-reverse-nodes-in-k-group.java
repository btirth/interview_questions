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
    /**
    temp.next = 1 // prev
    head = 2

    reversed = reverse(temp.next); // 2
    temp.next = reversed
    temp = prev

    temp.next = head.next;
    head = head.next;
    
    
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tempHead = new ListNode();
        ListNode temp = tempHead;
        tempHead.next = head;

        int count = 1;
        while(head != null && head.next != null) {
            head = head.next;
            count++;

            if(count == k) {
                ListNode tempPrev = temp.next;
            
                ListNode nextHead = head.next;
                head.next = null;
                ListNode reversed = reverse(temp.next);
                temp.next = reversed;
                temp = tempPrev;
                temp.next = nextHead;
                head = nextHead;
                count = 1;
            }
        }

        return tempHead.next;
    }

    ListNode reverse(ListNode node) {
        ListNode prev = null;
        while(node != null) {
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }
        return prev;
    }
}