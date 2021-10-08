'''

Given the head of a singly linked list, return true if it is a palindrome.

Example 1:
Input: head = [1,2,2,1]
Output: true

Example 2:
Input: head = [1,2]
Output: false
 
Constraints:
The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9
 
Follow up: Could you do it in O(n) time and O(1) space?

'''


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        def reverse(head):
            
            if head is None:
                return head
            
            prev = None
            while head is not None:
                temp = head.next
                head.next = prev
                prev = head
                head = temp

            return prev
        
        faster = head
        slower = head
        
        while faster.next is not None and faster.next.next is not None:
            faster = faster.next.next
            slower = slower.next
            
        slower.next = reverse(slower.next)
        
        left = head
        right = slower.next
        
        while right is not None:
            if left.val != right.val:
                return False
            
            left = left.next
            right = right.next
            
        return True;
        
        
