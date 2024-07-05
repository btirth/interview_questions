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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = new int[] {-1, -1};
        int firstCriticalPt = -1;
        int lastCriticalPt = -1;
        int curr = 0;
        int prev = head.val;
        curr = 1;
        head = head.next;

        while(head.next != null) {
            if((head.val < head.next.val && head.val < prev) || 
                head.val > head.next.val && head.val > prev
            ) {
                if(lastCriticalPt != -1 ) {
                    
                    ans[0] = ans[0] == -1 ? 
                                curr - lastCriticalPt : 
                                Math.min(ans[0], curr - lastCriticalPt);
                    ans[1] = Math.max(ans[1], curr - firstCriticalPt);
                } else {
                    firstCriticalPt = curr;
                }
                
                lastCriticalPt = curr;
            }

            prev = head.val;
            head = head.next;
            curr++;
        } 

        return ans;
    }
}