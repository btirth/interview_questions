/*

Given a singly linked list, determine if it is a palindrome.

Example 1:
    Input: 1->2
    Output: false

Example 2:
    Input: 1->2->2->1
    Output: true


*/


class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> nums = new Stack<Integer>();
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null ) {
            nums.push(slow.val);
            fast = fast.next.next;
            slow = slow.next;
        }
        
        if(fast != null) {
            System.out.println(slow.val);
            
            slow = slow.next;
        }
        
        while(slow != null && !nums.empty()) {
            int top = nums.pop().intValue();
            if(slow.val != top) {
                return false;
            }
            slow = slow.next;
            
        }
        
        return true;
    } 
}