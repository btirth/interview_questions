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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.val, b.val));
        for(ListNode list: lists) {
            if(list != null)
                pq.add(list);
        }

        ListNode head = new ListNode();
        ListNode temp = head;

        while(!pq.isEmpty()) {
            ListNode list = pq.poll();
            if(list.next != null) {
                pq.add(list.next);
            }

            head.next = list;
            head = head.next;
        }


        return temp.next;
    }
}