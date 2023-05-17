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
    
    public int pairSum(ListNode head) {
        ListNode tempHead = head;
        Stack<Integer> stack = new Stack<>();
        while(tempHead != null) {
            stack.add(tempHead.val);
            tempHead = tempHead.next;
        }

        ListNode fast = head;
        ListNode slow = head;
        int ans = 0;
        while(fast != null && fast.next != null) {
            ans = Math.max(slow.val+stack.pop(), ans);
            slow = slow.next;
            fast = fast.next.next;
        }

        return ans;
    }
}