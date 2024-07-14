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
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode temp = newHead;
        boolean[] numsIdx = new boolean[100001];
        for(int num: nums) {
            numsIdx[num] = true;
        }

        while(newHead.next != null) {
            if(numsIdx[newHead.next.val]) {
                newHead.next = newHead.next.next;
            } else {
                newHead = newHead.next;
            }
        }

        return temp.next;
    }
}