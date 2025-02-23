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
    public ListNode reverseKGroup(ListNode head, int k) {
        /**
        [1,2,3,4,5]
        res = 0
        tempHead = head = 1 -> len = 0
        head = 2 -> len = 1

        if(len % (k-1) == 0) {
            next = head.next = 3
            reversed = reverse([1,2]) = [2,1]
            res.next = reversed = [0,2,1]
            res = tempHead = 1
            len = 0
            head = next
            tempHead = next
        }
        
        tempHead = head = 3 -> len = 0
        head = 4 -> len = 1

        head = 5
        tempHead = 5


        at the end 
        if(tempHead != null) 
            res.next = tempHead

        return tempRes.next    
         */

        if(k == 1 || head == null) {
            return head;
        }

        ListNode tempHead = head;
        ListNode res = new ListNode(0);
        ListNode tempRes = res;
        int len = 0;

        while(head != null) {
            len++;
            head = head.next;

            if(head != null && len == (k-1)) {
                ListNode next = head.next;
                head.next = null;
                ListNode reversed = reverse(tempHead);
                res.next = reversed;
                res = tempHead;
                len = 0;
                head = next;
                tempHead = next;
            }
        }

        if(tempHead != null) {
            res.next = tempHead;
        }
        
        return tempRes.next;
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
}