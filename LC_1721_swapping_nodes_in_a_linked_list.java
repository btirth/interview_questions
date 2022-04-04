/*

You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).

Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]

Example 2:
Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
Output: [7,9,6,6,8,7,3,0,9,5]

Example 3:
Input: head = [1], k = 1
Output: [1]

Example 4:
Input: head = [1,2], k = 1
Output: [2,1]

Example 5:
Input: head = [1,2,3], k = 2
Output: [1,2,3]
 
Constraints:
The number of nodes in the list is n.
1 <= k <= n <= 10^5
0 <= Node.val <= 100

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



// Swap Nodes
public ListNode swapNodes(ListNode head, int k) {
	// step 1 : find k-th from the front 
	ListNode front = head;
	ListNode dummy = new ListNode(0, head); 
	ListNode prevFront = dummy;
	ListNode nextFront = front.next;

	for (int i = 1; i < k && front != null; i++) {
		prevFront = prevFront.next;
		front = front.next;
		nextFront = nextFront.next;
	}

	// step 2 : find k-th node from the back 
	ListNode back = head;
	ListNode tail = front;
	ListNode prevBack = dummy;
	ListNode nextBack = back.next;

	while (tail.next != null) {
		prevBack = prevBack.next;
		back = back.next;
		tail = tail.next;
		nextBack = nextBack.next;
	}

	// if front and back nodes are the same, no need to swap 
	if (front == back) return head;

	// step 3 : swap nodes 
	// We need to consider two case, 
	// 1. the front and back nodes are adjacent, 2. not adjacent

	// switch the representation of front and back for convenience 
	// if back -> front, back node is adjacent to and in front of the front node 
	if (back.next == front) {
		ListNode temp = back;
		prevFront = prevBack;
		nextBack = nextFront;
		back = front;
		front = temp;
	}

	// actual swapping 
	prevFront.next = back;
	if (front.next == back) {
		// case 1 : adjacent 
		back.next = front;
	} else { 
		// case 2 : not adjacent 
		back.next = nextFront;
		prevBack.next = front;
	}
	front.next = nextBack;

	// head could be different 
	return dummy.next;
}




//Swap values
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        
        ListNode fast = head;
        ListNode slow = head;
        
        for(int i = 1; i < k; i++){
            fast = fast.next;
        }
        
        ListNode temp = fast;
        
        while(temp.next != null){
            slow = slow.next;
            temp = temp.next;
        }
        
        int val = fast.val;
        fast.val = slow.val;
        slow.val = val;
        
        return head;
    }
}
