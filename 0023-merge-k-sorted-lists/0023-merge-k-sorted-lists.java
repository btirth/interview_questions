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
        ListNode res = new ListNode(0);
        ListNode resHead = res;
        
        for(ListNode list: lists) {
            if(list != null)
                pq.add(list);
        }

        while(!pq.isEmpty()) {
            ListNode list = pq.poll();

            if(list.next != null)
                pq.add(list.next);

            res.next = list;
            res = res.next;
            res.next = null;
        }

        return resHead.next;
    }
}