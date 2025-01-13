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
    public void reorderList(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        Stack<ListNode> stack = new Stack<>();

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        while(slow != null) {
            stack.add(slow);
            slow = slow.next;
        }

        while(!stack.isEmpty()) {
            ListNode temp = head.next;
            head.next = stack.pop();
            head = head.next;
            head.next = temp;
            head = head.next;
        }

        if(head != null && head.next != null)
            head.next.next = null;
    }
}