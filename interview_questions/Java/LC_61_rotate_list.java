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


// 1st Approach

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode i = head;
        ListNode j = head;
        int l = len(head)+1;
        k%=l;
        
        if(k==0) {
            return head;
        }
        for(int m=1; m<=k; m++) {
            j = j.next;
        }
        
        while(j != null && j.next != null) {
            i = i.next;
            j = j.next;
        }
        
        ListNode temp = i.next;
        ListNode ans = temp;
        i.next = null;
        while(temp != null && temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        return ans;
    }
    
    int len(ListNode head) {
        int l = 0;
        while(head != null && head.next != null) {
            l++;
            head = head.next;
        }
        
        return l;
    }
}




// 2nd Approach

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) {
            return head;
        }
        int l = len(head);
        k %= l;
        if(k == 0) {
            return head;
        }
        ListNode i = head;
        for(int m=0; m<l-k-1; m++) {
            head = head.next;
        }
        ListNode j = head.next;
        ListNode result = j;
        head.next = null;
        
        while(j != null && j.next != null) {
            j = j.next;
        }
        
        j.next = i;
        return result;
    }
    
    int len(ListNode head) {
        int l = 1;
        while(head != null && head.next != null) {
            l++;
            head = head.next;
        }
        
        return l;
    }
}