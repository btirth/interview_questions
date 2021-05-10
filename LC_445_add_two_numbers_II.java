/*

You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
    What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:
    Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 8 -> 0 -> 7

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

class Sum {
    ListNode list;
    int carry;
}
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = len(l1);
        int len2 = len(l2);
        
        if(len2 > len1) {
            l1 = addPadding(l1, len2-len1);
        } else if(len2 < len1) {
            l2 = addPadding(l2, len1-len2);
        }
        
        Sum rightSum = add(l1, l2);
        if(rightSum.carry > 0) {
            ListNode node = new ListNode(rightSum.carry);
            node.next = rightSum.list;
            rightSum.list = node;
        }
        return rightSum.list;
    }
    
    int len(ListNode head) {
        int l = 1;
        
        while(head != null) {
            head = head.next;
            l++;
        }
        return l;
    }
    
    ListNode addPadding(ListNode head, int d) {
        while(d > 0) {
            ListNode node = new ListNode(0);
            node.next = head;
            head = node;
            d--;
        }
        return head;
    }
    
    Sum add(ListNode l1, ListNode l2) {
        if(l1.next == null && l2.next == null) {
            int value = l1.val+l2.val;
            Sum sum = new Sum();
            sum.carry = value/10;
            sum.list = new ListNode(value%10);
            sum.list.next = null;
            return sum;
        }
        
        Sum rightSum = add(l1.next, l2.next);
        int value = l1.val + l2.val + rightSum.carry;
        Sum sum = new Sum();
        sum.carry = value/10;
        sum.list = new ListNode(value%10);
        sum.list.next = rightSum.list;
        
        return sum;
    }
}