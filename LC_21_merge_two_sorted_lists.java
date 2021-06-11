/*

Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.

Example 1:
    Input: l1 = [1,2,4], l2 = [1,3,4]
    Output: [1,1,2,3,4,4]

Example 2:
    Input: l1 = [], l2 = []
    Output: []

Example 3:
    Input: l1 = [], l2 = [0]
    Output: [0]
 
Constraints:
    The number of nodes in both lists is in the range [0, 50].
    -100 <= Node.val <= 100
    Both l1 and l2 are sorted in non-decreasing order.

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


// Brute Approach
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode result = head;
        while(l1 != null && l2 != null) {
            if(l1.val == l2.val) {
                head.next = new ListNode(l1.val);
                head = head.next;
                head.next = new ListNode(l2.val);
                head = head.next;
                l1 = l1.next;
                l2 = l2.next;
            } else if(l1.val < l2.val) {
                head.next = new ListNode(l1.val);
                head = head.next;
                l1 = l1.next;
            } else {
                head.next = new ListNode(l2.val);
                head = head.next;
                l2 = l2.next;
            }
        }
        
        while(l1 != null) {
            head.next = new ListNode(l1.val);
            head = head.next;
            l1 = l1.next;
        }
        
        while(l2 != null) {
            head.next = new ListNode(l2.val);
            head = head.next;
            l2 = l2.next;              
        }
            
            
        
        return result.next;
    }
}




// More Optimized Space Complexity
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode current = new ListNode();
        ListNode result = current;
        while(l1 != null && l2 != null) {
            if(l1.val == l2.val) {
                current.next = l1;
                l1 = l1.next;
                current = current.next;
                current.next = l2;
                l2 = l2.next;
                current = current.next;
            } else if(l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
                current = current.next;
            } else {
                current.next = l2;
                l2 = l2.next;
                current = current.next;
            }
        }
    
        while(l1 != null) {
            current.next = l1;
             l1 = l1.next;
            current = current.next;
        }
        
        while(l2 != null) {
            current.next = l2;
            l2 = l2.next;
            current = current.next;
        }
        
        return result.next;
    }
}




class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
