/*

You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

Example 1:
Input: head = [1,2,3,4]
Output: [1,4,2,3]

Example 2:
Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
 
Constraints:
The number of nodes in the list is in the range [1, 5 * 10^4].
1 <= Node.val <= 1000

*/



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
        int l = len(head);
        if(l==1 || l==2) {
            return ;
        }
        ListNode node = new ListNode();
        node.next = head;
        
        ListNode result = node;
        
        for(int i=1; i<=l/2; i++) {
            node = node.next;
        }
        ListNode next = node.next.next;
        next = reverse(next);
        node.next.next = null;
        
        while(head != null && next != null) {
            ListNode nextHead = head.next;
            head.next = next;
            ListNode nextNext = next.next;
            next.next = nextHead;
            head = nextHead;
            next = nextNext;
        }
        
        
    }
    
    int len(ListNode head) {
        int l = 1;
        while(head.next != null) {
            l++;
            head = head.next;
        }
        
        return l;
    }
    
    ListNode reverse(ListNode node) {
        ListNode head = null;
        int l = 1;
        while(node != null) {
            l++;
            ListNode n = new ListNode(node.val);
            n.next = head;
            head = n;
            node = node.next;
        }
        System.out.println(--l);
        return head;
    }
}