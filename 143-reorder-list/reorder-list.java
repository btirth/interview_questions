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
        int len = getLen(head);
       
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        ListNode prev = head;
        for(int i=0; i<=len/2; i++) {
            prev = head;
            head = head.next;
        }

        prev.next = null;
        ListNode reversedNode = reverse(head);
        
        head = temp;
        while(head != null && reversedNode != null) {
            ListNode tempNode = head.next;
            head.next = reversedNode;
            reversedNode = reversedNode.next;
            head.next.next = tempNode;
            head = head.next.next;
        }
    }

    ListNode reverse(ListNode head) {
        ListNode prev = null;
        while(head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        return prev;
    }

    int getLen(ListNode head) {
        int len = 0;
        while(head != null) {
            len++;
            head = head.next;
        }

        return len;
    }
}