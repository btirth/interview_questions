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
    public boolean isPalindrome(ListNode head) {
        int len = getLen(head);
        Stack<Integer> stack = new Stack<>();
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {

            stack.push(slow.val);
            fast = fast.next.next;
            slow = slow.next;
        }

        if(len%2 == 1) {
            slow = slow.next;
        }

        while(slow != null) {
            if(stack.isEmpty() || slow.val != stack.pop()) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }

    int getLen(ListNode root) {
        int len = 0;
        while(root != null) {
            len++;
            root = root.next;
        }

        return len;
    }
}