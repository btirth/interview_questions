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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode node = new ListNode();
        node.next = list1;
        ListNode head = node;
        int i=1;
        node = node.next;
        while(i<a) {
            i++;
            node = node.next;
        }
        ListNode prev = node;
        
        while(i<=b) {
            i++;
            node = node.next;
        }
      
        ListNode next = node.next;
        
        prev.next = list2;
        while(list2.next != null) {
            list2 = list2.next;
        }
        list2.next = next;
        return head.next;
    }
}