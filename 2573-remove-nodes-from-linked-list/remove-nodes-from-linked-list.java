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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        
        while(head != null) {
            
            while(!st.isEmpty() && st.peek().val < head.val) {
                st.pop();
            }
            st.push(head);
            head = head.next;
        }
        
        ListNode newHead = null;
        ListNode newList = null;
        while(!st.isEmpty()) {
            if(newHead == null) {
                newHead = st.pop();
                newList = newHead;
            } else {
                newHead = st.pop();
                newHead.next = newList;
                newList = newHead;
            }
        }
        
        return newList;
    }
}