/*

Given the head of a linked list, rotate the list to the right by k places.

Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Example 2:
Input: head = [0,1,2], k = 4
Output: [2,0,1]
 
Constraints:
The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 10^9


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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) {
            return head;
        }
        
        int len = getLen(head);
        k %= len;
        if(k == 0) {
            return head;
        }
        ListNode tempHead = head;
        
        while(len-- > k+1) {
            head = head.next;
        }
        
        ListNode newHead = head.next;
        head.next = null;
        
        ListNode temp = newHead;
        while(temp != null && temp.next != null) {
            temp = temp.next;
        }
        
        if(temp != null) {
            temp.next = tempHead;
        }
        
        return newHead;
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
