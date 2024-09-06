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
        Set<Integer> numsSet = new HashSet<>();
        for(int num: nums) {
            numsSet.add(num);
        }
        ListNode tempHead = new ListNode();
        tempHead.next = head;
        ListNode temp = tempHead;

        while(temp.next != null) {
            if(numsSet.contains(temp.next.val)) {
                ListNode next = temp.next.next;
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        return tempHead.next;
    }
}