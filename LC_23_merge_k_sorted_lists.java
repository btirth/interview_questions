/*

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

Example 1:
  Input: lists = [[1,4,5],[1,3,4],[2,6]]
  Output: [1,1,2,3,4,4,5,6]
  Explanation: The linked-lists are:
    [
      1->4->5,
      1->3->4,
      2->6
    ]
    merging them into one sorted list:
    1->1->2->3->4->4->5->6

Example 2:
  Input: lists = []
  Output: []

Example 3:
  Input: lists = [[]]
  Output: []

Constraints:
  k == lists.length
  0 <= k <= 10^4
  0 <= lists[i].length <= 500
  -10^4 <= lists[i][j] <= 10^4
  lists[i] is sorted in ascending order.
  The sum of lists[i].length will not exceed 10^4.

*/

class Solution {
    class Pair implements Comparable<Pair>{
        ListNode node;
        int val;

        Pair(ListNode node, int val) {
            this.val = val;
            this.node = node;
        }

        public int compareTo(Pair p) {
            return Integer.compare(this.val, p.val);
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        ListNode head = new ListNode(0);
        ListNode tempHead = head;

        for(ListNode node: lists) {
            if(node != null) {
                queue.add(new Pair(node, node.val));
            }
        } 

        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            tempHead.next = pair.node;
            tempHead = tempHead.next;

            if(pair.node.next != null) {
                pair.node = pair.node.next;
                pair.val = pair.node.val;
                queue.add(pair);
            }   
        }

        return head.next;
    }
}
